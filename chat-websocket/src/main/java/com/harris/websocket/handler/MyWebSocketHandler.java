package com.harris.websocket.handler;

import com.harris.common.redis.util.RedisUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * @author Harris
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(MyWebSocketHandler.class);
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("connection success,{}", session.getId());
        addNewSession(session);
        sendMessageTo(session.getId(), "connection success");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage textMessage) {
            String messageStr = textMessage.getPayload();
            sendMessageTo(session.getId(), messageStr);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("connection error,{}", exception.getMessage());
        sendMessageTo(session.getId(), "connection error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        sendMessageTo(session.getId(), "connection closed");
        redisUtils.removeCacheObject(session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private void addNewSession(WebSocketSession session) throws Exception {
        if (!redisUtils.hasCacheObject(session.getId())) {
            redisUtils.setCacheObject(session.getId(), session);
        }
    }

    public void sendMessageTo(String sessionId, String message) throws Exception {
        Object cacheObject = redisUtils.getCacheObject(sessionId);
        if (cacheObject != null) {
            WebSocketSession session = (WebSocketSession) cacheObject;
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
            redisUtils.removeCacheObject(sessionId);
        }
    }
}

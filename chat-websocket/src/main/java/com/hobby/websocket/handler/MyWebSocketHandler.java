package com.hobby.websocket.handler;

import com.hobby.websocket.util.MessageUtils;
import com.hobby.websocket.util.WebSocketUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * @author Harris
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        logger.info("connection success,{}", session.getId());
        WebSocketUtils.putSession(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage textMessage) {
            String messageStr = textMessage.getPayload();
            Thread.sleep(1000);
            MessageUtils.sendMsg(session, messageStr + "    ————    <" + session.getId() + ">");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        logger.error("connection error,{}", exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        logger.warn("session id：{}，connection closed,{}", session.getId(), closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

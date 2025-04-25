package com.harris.websocket.handler;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.time.Instant;
import java.time.ZoneId;

/**
 * @author Harris
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("connection success,{}", session.getId());
        sendMessageTo(session, "connection success");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage textMessage) {
            String messageStr = textMessage.getPayload();
            Thread.sleep(1000);
            sendMessageTo(session, messageStr+" success"+"<"+session.getId()+"> ————"+Instant.now().atZone(ZoneId.of(
                    "Asia" +
                    "/Shanghai")));
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("connection error,{}", exception.getMessage());
        sendMessageTo(session, "connection error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        sendMessageTo(session, "connection closed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessageTo(WebSocketSession session, String message) throws Exception {
        if (session.isOpen()) {
            session.sendMessage(new TextMessage(message));
        }
    }
}

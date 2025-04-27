package com.hobby.websocket.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Harris
 */
public class MessageUtils {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MessageUtils.class);

    public static void sendMsg(WebSocketSession session, String message) {
        if (StringUtils.isBlank(message)) {
            return;
        }
        if (session.isOpen()) {
            try {
                session.sendMessage(new org.springframework.web.socket.TextMessage(message));
            } catch (Exception e) {
                logger.error("send message error,{}", e.getMessage());
            }
        }
    }

    public static void sendMsg(String loginId, String message) {
        if (StringUtils.isBlank(loginId) || StringUtils.isBlank(message)) {
            return;
        }
        try {
            WebSocketSession session = WebSocketUtils.getSession(loginId);
            if (session != null && session.isOpen()) {
                session.sendMessage(new org.springframework.web.socket.TextMessage(message));
            }
        }catch (Exception e){
            logger.error("send message error,{}", e.getMessage());
        }
    }
}

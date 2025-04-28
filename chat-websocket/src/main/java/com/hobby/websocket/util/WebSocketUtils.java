package com.hobby.websocket.util;


import com.hobby.core.util.StringUtils;
import com.hobby.websocket.constant.WebSocketConstants;
import org.springframework.web.socket.WebSocketSession;


/**
 * @author Harris
 */
public class WebSocketUtils {

    private WebSocketUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void putSession(WebSocketSession session) {
        if (session != null && session.isOpen() && StringUtils.isNotBlank(session.getId())) {
            WebSocketConstants.SESSION_MAP.put(session.getId(), session);
        }
    }

    public static void removeSession(String key) {
        WebSocketConstants.SESSION_MAP.remove(key);
    }

    public static WebSocketSession getSession(String key) {
        return WebSocketConstants.SESSION_MAP.get(key);
    }

    public static void removeSessionAll() {
        WebSocketConstants.SESSION_MAP.clear();
    }

    public static void disConnectSession() {
        WebSocketConstants.SESSION_MAP.forEach((key, value) -> disConnectSession(value));
    }

    public static void disConnectSession(WebSocketSession session) {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

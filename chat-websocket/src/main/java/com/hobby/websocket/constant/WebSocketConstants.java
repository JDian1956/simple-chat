package com.hobby.websocket.constant;

import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Harris
 */
public class WebSocketConstants {

    /**
     * websocket session map
     */
    public static final ConcurrentHashMap<String, WebSocketSession> SESSION_MAP = new ConcurrentHashMap<>();

    /**
     * websocket session key
     */
    public static final String SESSION_CACHE = "hobby-sessions:web-socket-key";

}

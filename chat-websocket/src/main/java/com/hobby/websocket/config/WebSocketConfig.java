package com.hobby.websocket.config;

import com.hobby.websocket.handler.MyWebSocketHandler;
import com.hobby.websocket.interceptor.MyHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Harris
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MyWebSocketHandler webSocketHandler;
    private final MyHandshakeInterceptor handshakeInterceptor;

    @Autowired
    public WebSocketConfig(MyWebSocketHandler webSocketHandler,
                           MyHandshakeInterceptor handshakeInterceptor) {
        this.webSocketHandler = webSocketHandler;
        this.handshakeInterceptor = handshakeInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/chat")
                .addInterceptors(handshakeInterceptor)
                .setAllowedOrigins("*");

    }
}

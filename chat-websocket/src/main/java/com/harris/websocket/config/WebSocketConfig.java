package com.harris.websocket.config;

import com.harris.websocket.handler.MyWebSocketHandler;
import com.harris.websocket.interceptor.MyHandshakeInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Harris
 */
@Component
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(), "/ws")
                .addInterceptors(new MyHandshakeInterceptor())
                .setAllowedOrigins("*");

    }
}

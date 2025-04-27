package com.hobby.websocket.config;

import com.hobby.websocket.constant.WebSocketConstants;
import com.hobby.websocket.util.WebSocketUtils;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 */
@Component
public class WebSocketCleaner implements SmartLifecycle {
    private boolean running = false;

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void stop() {
        // 断开所有 WebSocketSession 连接
        WebSocketConstants.SESSION_MAP.forEach((key, value) -> {
            System.out.println("断开连接：" + key);
        });
        WebSocketUtils.disConnectSession();
        // TODO 停止时清除所有缓存
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}

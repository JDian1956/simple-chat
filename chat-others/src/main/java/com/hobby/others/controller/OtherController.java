package com.hobby.others.controller;

import com.hobby.api.RemoteAuthService;
import com.hobby.api.RemoteNotifyService;
import com.hobby.core.util.ResponseResult;
import com.hobby.others.client.RabbitClients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Harris
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class OtherController {

    private final RemoteNotifyService remoteNotifyService;
    private final RemoteAuthService remoteAuthService;
    private final RabbitClients rabbitClients;
    private final ThreadPoolTaskExecutor taskExecutor;

    @GetMapping("/test")
    public String getOthers() {
        return "others";
    }

    @GetMapping("/notify")
    public String getNotify() {
        return remoteNotifyService.getNotify();
    }

    @GetMapping("/auth")
    public <T> ResponseResult<T> getAuth() {
        return remoteAuthService.getDemo();
    }

    @GetMapping("/mq/{totalMessages}/{sharding}")
    public ResponseResult<Object> mqTest(@PathVariable("totalMessages") int totalMessages,
                                         @PathVariable("sharding") int sharding) {

        int messagesPerThread = totalMessages / sharding;

        IntStream.range(0, sharding).forEach(i -> {
            int start = i * messagesPerThread + 1;
            int end = (i == sharding - 1) ? totalMessages : start + messagesPerThread - 1;
            taskExecutor.submit(() -> {
                log.info(Thread.currentThread().getName()+ "开始序号：" + start + "，结束序号：" + end);
                for (int j = start; j <= end; j++) {
                    rabbitClients.sendCommonMessageCorrelated("第" + j + "条消息");
                }
            });
        });

        return ResponseResult.success();
    }
}

package com.hobby.others;

import com.hobby.others.client.RabbitClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Harris
 */
@ComponentScan(basePackages = "com.hobby")
@EnableFeignClients(basePackages = "com.hobby.api")
@EnableDiscoveryClient
@SpringBootApplication
public class ChatOthersApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ChatOthersApplication.class, args);

        RabbitClients rabbitClients = run.getBean(RabbitClients.class);
        int threadCount = 5;
        int totalMessages = 5_000;
        int messagesPerThread = totalMessages / threadCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        ArrayList<CompletableFuture<Void>> futures = new ArrayList<>();

        IntStream.range(0, threadCount).forEach(i -> {
            int start = i * messagesPerThread + 1;
            int end = (i == threadCount - 1) ? totalMessages : start + messagesPerThread - 1;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (int j = start; j <= end; j++) {
                    rabbitClients.sendCommonMessageCorrelated("第" + j + "条消息");
                }
            }, executorService);

            futures.add(future);
        });

        try {
            CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            allOf.join();
        } finally {
            executorService.shutdown();
        }
    }
}

package com.hobby.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Harris
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ChatNotifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatNotifyApplication.class, args);
    }
}

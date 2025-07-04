package com.hobby.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Harris
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ChatGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatGateWayApplication.class, args);
    }
}

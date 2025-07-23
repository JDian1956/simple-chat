package com.hobby.others;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Harris
 */
@ComponentScan(basePackages = "com.hobby")
@EnableFeignClients(basePackages = "com.hobby.api")
@EnableDiscoveryClient
@SpringBootApplication
public class ChatOthersApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatOthersApplication.class, args);
    }
}

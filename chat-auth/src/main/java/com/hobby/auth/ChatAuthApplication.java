package com.hobby.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
* @author Harris
* 
*/
@ComponentScan(basePackages = "com.hobby")
@EnableDiscoveryClient
@SpringBootApplication
public class ChatAuthApplication {
    public static void main(String[] args) {
       SpringApplication.run(ChatAuthApplication.class, args);
    }
}

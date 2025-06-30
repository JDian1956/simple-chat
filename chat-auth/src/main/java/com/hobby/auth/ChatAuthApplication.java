package com.hobby.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
* @author Harris
* 
*/
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.hobby")
public class ChatAuthApplication {
    public static void main(String[] args) {
       SpringApplication.run(ChatAuthApplication.class, args);
    }
}

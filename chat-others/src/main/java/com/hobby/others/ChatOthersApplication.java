package com.hobby.others;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
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
        ConfigurableApplicationContext run = SpringApplication.run(ChatOthersApplication.class, args);

//        RabbitClients rabbitClients = run.getBean(RabbitClients.class);
//        int i = 100000;
//        while (i >= 0) {
//            rabbitClients.sendCommonMessageCorrelated("第" + i + "条消息");
//            i--;
//        }
    }
}

package com.hobby.others;

import com.hobby.others.client.RabbitClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Harris
 */
@SpringBootApplication
public class ChatOthersApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ChatOthersApplication.class, args);

        RabbitClients rabbitClients = run.getBean(RabbitClients.class);
        int i = 100000;
        while (i >= 0) {
            rabbitClients.sendCommonMessageCorrelated("第" + i + "条消息");
            i--;
        }
    }
}

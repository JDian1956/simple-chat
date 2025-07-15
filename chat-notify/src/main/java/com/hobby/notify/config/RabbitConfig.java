package com.hobby.notify.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Harris
 */
@Configuration
public class RabbitConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public MessageRecoverer messageRecoverer(RabbitTemplate rabbitTemplate) {
        return new RepublishMessageRecoverer(rabbitTemplate, "common-exchange", "error");
    }


    @Bean
    public Queue dlxQueue() {
        return QueueBuilder.durable("dlx.queue").build();
    }

    @Bean
    public Queue emailQueue() {
        return QueueBuilder.durable("email.queue")
                .withArgument("x-dead-letter-exchange", "dlx-exchange")
                .withArgument("x-dead-letter-routing-key", "dlx")
                .withArgument("x-message-ttl", 60000)
                .withArgument("x-delivery-limit", 3)
                .build();
    }

    @Bean
    public DirectExchange dlxExchange() {
        return ExchangeBuilder.directExchange("dlx-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange commonExchange() {
        return ExchangeBuilder.directExchange("common-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public Binding bindingEmailQueue() {
        return BindingBuilder.bind(emailQueue())
                .to(commonExchange())
                .with("common");
    }

    @Bean
    public Binding bindingDlxQueue() {
        return BindingBuilder.bind(dlxQueue())
                .to(dlxExchange())
                .with("dlx");
    }
}

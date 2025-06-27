package com.hobby.others.client;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Harris
 */
@RequiredArgsConstructor
@Component
public class RabbitClients {
    private final RabbitTemplate rabbitTemplate;

    private final static String COMMON_EXCHANGE = "common-exchange";
    private final static String COMMON_ROUTING_KEY = "common";

    public void sendCommonMessage(String message) {
        rabbitTemplate.convertAndSend(COMMON_EXCHANGE, COMMON_ROUTING_KEY, message, messageDeliveryMode -> {
            messageDeliveryMode.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return messageDeliveryMode;
        });
    }

    public void sendCommonMessageCorrelated(Object message) {
        System.out.println("发送消息:" + message);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        correlationData.getFuture().whenComplete((ack, cause) -> {
            if (!ack.isAck()) {
                System.out.println("消息发送失败");
            }
        });
        rabbitTemplate.convertAndSend(COMMON_EXCHANGE, COMMON_ROUTING_KEY, message, messageDeliveryMode -> {
            messageDeliveryMode.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return messageDeliveryMode;
        }, correlationData);
    }
}

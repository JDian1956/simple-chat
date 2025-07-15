package com.hobby.others.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Harris
 */
@Slf4j
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
        try {
            String msgId = UUID.randomUUID().toString().replaceAll("-", "");
//            log.info("发送消息，ID: {}, 内容: {}", msgId, message);

            CorrelationData correlationData = new CorrelationData(msgId);
            correlationData.getFuture().whenComplete((ack, cause) -> {
                if (!ack.isAck()) {
                    log.info("消息发送失败，ID: {}, 原因: {}", msgId, cause.getMessage());
                }
            });
            rabbitTemplate.convertAndSend(COMMON_EXCHANGE, COMMON_ROUTING_KEY, message, messageDeliveryMode -> {
                messageDeliveryMode.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return messageDeliveryMode;
            }, correlationData);
        } catch (AmqpException e) {
            log.error("发送消息失败，内容：{}，原因: {}", message, e.getMessage());
        }
    }
}

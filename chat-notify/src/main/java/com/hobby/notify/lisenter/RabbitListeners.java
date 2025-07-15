package com.hobby.notify.lisenter;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Harris
 */
@Component
public class RabbitListeners {
    private final Logger logger = LoggerFactory.getLogger(RabbitListeners.class);

    @RabbitListener(queues = "email.queue", concurrency = "5")
    public void feedBackEmail(Message message,
                              String body,
                              Channel channel,
                              @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        try {
            String messageId = message.getMessageProperties().getMessageId();
            //logger.info("Message ID: {}", messageId);
            //logger.info("Message Body: {}", body);
            TimeUnit.MILLISECONDS.sleep(10);

            channel.basicAck(deliveryTag, false);
        } catch (InterruptedException | IOException e) {
            try {
                // 拒绝消息并重新入队
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException ex) {
                logger.error("Failed to nack message", ex);
            }
            throw new RuntimeException(e);
        }
    }

    @RabbitListener(queues = "dlx.queue")
    public void errorMessageRecover(String message,
                                    Channel channel,
                                    @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        logger.error("receive error message:{}", message);
        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.hobby.notify.lisenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Harris
 */
@Component
public class RabbitListeners {
    private final Logger logger = LoggerFactory.getLogger(RabbitListeners.class);

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "email.queue",durable = "true"),
                    exchange = @Exchange(name = "common-exchange", type = "direct"),
                    key = "common"
            ),
            concurrency = "5"
    )
    public void feedBackEmail(String message) {
        try {
            logger.info("receive message:{}", message);
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "error.queue"),
                    exchange = @Exchange(name = "common-exchange", type = "direct"),
                    key = "error"
            )
    )
    public void errorMessageRecover(String message) {
        logger.error("receive error message:{}", message);
    }
}

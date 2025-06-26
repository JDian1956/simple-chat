package com.hobby.others.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Harris
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 创建消息转换器
     */
    @Bean
    public MessageConverter messageConverter() {
        // 创建消息转换器
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        // 创建消息ID
        jsonMessageConverter.setCreateMessageIds(true);
        return jsonMessageConverter;
    }
}

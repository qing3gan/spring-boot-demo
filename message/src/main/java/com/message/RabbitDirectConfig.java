package com.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Queue: AMQP消息队列
 * DirectExchange: routing key -> routing key queue
 * Binding: 绑定Exchange -> Queue
 *
 * @author agony
 * @date 2020/5/23 12:25
 */
@Configuration
public class RabbitDirectConfig {
    @Bean
    Queue queue() {
        return new Queue("direct-q");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-ex", true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}

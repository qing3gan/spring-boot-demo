package com.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FanoutExchange: all queue
 *
 * @author agony
 * @date 2020/5/23 18:35
 */
@Configuration
public class RabbitFanoutConfig {
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-ex", true, false);
    }

    @Bean
    Queue queue1() {
        return new Queue("fanout-q1");
    }

    @Bean
    Queue queue2() {
        return new Queue("fanout-q2");
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
}

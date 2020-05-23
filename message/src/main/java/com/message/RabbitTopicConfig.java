package com.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicExchange: routing key -> routing queue
 *
 * @author agony
 * @date 2020/5/23 18:48
 */
@Configuration
public class RabbitTopicConfig {
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-ex", true, false);
    }

    @Bean
    Queue queue1() {
        return new Queue("topic-q1");
    }

    @Bean
    Queue queue2() {
        return new Queue("topic-q2");
    }

    @Bean
    Queue queue3() {
        return new Queue("topic-q3");
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("topic-1");
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("topic-2");
    }

    @Bean
    Binding binding3() {
        return BindingBuilder.bind(queue3()).to(topicExchange()).with("topic-3");
    }
}

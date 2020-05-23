//package com.message;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.HeadersExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * HeadersExchange: message header -> route queue
// *
// * @author agony
// * @date 2020/5/23 19:21
// */
//@Configuration
//public class RabbitHeadersConfig {
//    @Bean
//    HeadersExchange headersExchange() {
//        return new HeadersExchange("headers-ex");
//    }
//
//    @Bean
//    Queue queue1() {
//        return new Queue("headers-q1");
//    }
//
//    @Bean
//    Queue queue2() {
//        return new Queue("headers-q2");
//    }
//
//    @Bean
//    Binding binding1() {
//        return BindingBuilder.bind(queue1()).to(headersExchange()).where("headers1").exists();
//    }
//
//    @Bean
//    Binding binding2() {
//        return BindingBuilder.bind(queue2()).to(headersExchange()).where("headers2").exists();
//    }
//}

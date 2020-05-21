package com.message;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

/**
 * ActiveMQQueue: Active消息队列
 *
 * @author agony
 * @date 2020/5/18 23:23
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    Queue queue() {
        return new ActiveMQQueue("amq");
    }
}

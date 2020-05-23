package com.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/23 18:55
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "topic-q1")
    public void handler1(String msg) {
        System.out.println("TopicReceiver1: " + msg);
    }

    @RabbitListener(queues = "topic-q2")
    public void handler2(String msg) {
        System.out.println("TopicReceiver2: " + msg);
    }

    @RabbitListener(queues = "topic-q3")
    public void handler3(String msg) {
        System.out.println("TopicReceiver3: " + msg);
    }
}

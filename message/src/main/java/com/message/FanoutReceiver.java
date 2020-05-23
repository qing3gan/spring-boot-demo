package com.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/23 18:44
 */
@Component
public class FanoutReceiver {
    @RabbitListener(queues = "fanout-q1")
    public void handler1(String msg) {
        System.out.println("FanoutReceiver1: " + msg);
    }

    @RabbitListener(queues = "fanout-q2")
    public void handler2(String msg) {
        System.out.println("FanoutReceiver2: " + msg);
    }
}

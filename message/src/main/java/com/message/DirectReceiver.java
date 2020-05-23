package com.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/23 12:54
 */
@Component
public class DirectReceiver {
    @RabbitListener(queues = "direct-q")
    public void handler(String msg) {
        System.out.println("DirectReceiver: " + msg);
    }
}

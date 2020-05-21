package com.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * JmsMessagingTemplate: JMS消息发送模板
 * JmsListener: 消息消费者（订阅destination）
 *
 * @author agony
 * @date 2020/5/18 23:40
 */
@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate messagingTemplate;

    @Autowired
    Queue queue;

    public void send(Message msg) {
        messagingTemplate.convertAndSend(queue, msg);
    }

    @JmsListener(destination = "amq")
    public void receive(Message msg) {
        System.out.println("receive: " + msg);
    }
}

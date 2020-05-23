package com.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/18 23:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
//    @Autowired
//    JmsComponent jmsComponent;
//
//    @Test
//    public void contextLoads() {
//        Message msg = new Message();
//        msg.setContent("hello jms!");
//        msg.setDate(new Date());
//        jmsComponent.send(msg);
//    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void directTest() {
        rabbitTemplate.convertAndSend("direct-q", "hello direct");
    }

    @Test
    public void fanoutTest() {
        rabbitTemplate.convertAndSend("fanout-ex", null, "hello fanout");
    }

    @Test
    public void topicTest() {
        rabbitTemplate.convertAndSend("topic-ex", "topic-1", "hello topic1");
        rabbitTemplate.convertAndSend("topic-ex", "topic-2", "hello topic2");
        rabbitTemplate.convertAndSend("topic-ex", "topic-3", "hello topic3");
    }

    @Test
    public void headersTest() {
        org.springframework.amqp.core.Message msg1 = MessageBuilder
                .withBody("hello headers1".getBytes())
                .setHeader("headers1", "").build();
        org.springframework.amqp.core.Message msg2 = MessageBuilder
                .withBody("hello headers2".getBytes())
                .setHeader("headers2", "").build();
        rabbitTemplate.send(msg1);
        rabbitTemplate.send(msg2);
    }
}

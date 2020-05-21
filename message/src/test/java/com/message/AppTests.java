package com.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/18 23:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @Autowired
    JmsComponent jmsComponent;

    @Test
    public void contextLoads() {
        Message msg = new Message();
        msg.setContent("hello jms!");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }
}

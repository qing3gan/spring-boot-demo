//package com.message;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * desc
// *
// * @author agony
// * @date 2020/5/23 21:40
// */
//@Component
//public class HeadersReceiver {
//    @RabbitListener(queues = "headers-q1")
//    public void handler1(byte[] msg) {
//        System.out.println("HeadersReceiver1: " + new String(msg, 0, msg.length));
//    }
//
//    @RabbitListener(queues = "headers-q2")
//    public void handler2(byte[] msg) {
//        System.out.println("HeadersReceiver2: " + new String(msg, 0, msg.length));
//    }
//}

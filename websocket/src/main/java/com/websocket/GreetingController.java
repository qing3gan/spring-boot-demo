package com.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * MessageMapping: 接收Destination发送来的消息
 * SendTo: 转发消息到Broker
 * SimpMessagingTemplate: 点对点消息发送
 *
 * @author agony
 * @date 2020/5/14 22:40
 */
@Controller
public class GreetingController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        String from = principal.getName();
        chat.setFrom(from);
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}

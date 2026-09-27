package com.aditya.day14.chat;
import org.springframework.messaging.handler.annotation.*; import org.springframework.stereotype.Controller;
@Controller public class ChatController {
 public record Message(String roomId,String sender,String content,long timestamp){}
 @MessageMapping("/chat") @SendTo("/topic/messages") public Message chat(Message m){return new Message(m.roomId(),m.sender(),m.content(),System.currentTimeMillis());}
}

package com.aditya.day14.chat;
import org.springframework.context.annotation.Configuration; import org.springframework.messaging.simp.config.MessageBrokerRegistry; import org.springframework.web.socket.config.annotation.*;
@Configuration @EnableWebSocketMessageBroker public class ChatConfig implements WebSocketMessageBrokerConfigurer {
 public void configureMessageBroker(MessageBrokerRegistry r){r.enableSimpleBroker("/topic");r.setApplicationDestinationPrefixes("/app");}
 public void registerStompEndpoints(StompEndpointRegistry r){r.addEndpoint("/ws").setAllowedOriginPatterns("*");}
}

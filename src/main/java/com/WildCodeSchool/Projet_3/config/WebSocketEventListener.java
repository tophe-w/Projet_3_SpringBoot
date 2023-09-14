package com.WildCodeSchool.Projet_3.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.WildCodeSchool.Projet_3.entity.ChatMessage;
import com.WildCodeSchool.Projet_3.entity.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j

public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;
    
    @EventListener
    public void handleWebSocketDisconnectListener(
        SessionDisconnectEvent event
    ) {
       StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
       String username = (String) headerAccessor.getSessionAttributes().get("username");
       if (username != null) {
           log.info("User Disconnected : " + username);
           ChatMessage chatMessage = ChatMessage.builder()
                     .type(MessageType.LEAVER)
                     .sender(username)
                     .build();
              messagingTemplate.convertAndSend("/topic/public", chatMessage);
       }
    }
}

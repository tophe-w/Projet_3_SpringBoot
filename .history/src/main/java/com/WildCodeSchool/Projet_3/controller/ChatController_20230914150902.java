package com.WildCodeSchool.Projet_3.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.WildCodeSchool.Projet_3.entity.ChatMessage;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {
      

    @MessageMapping("/send-message")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
        
        @Payload ChatMessage chatMessage) {
            System.out.println("+++++++++++++++Réponse du serveur Spring : " + chatMessage);
        return chatMessage;
       
    }
    @MessageMapping("/addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor
            
    ) {   
          // ajout de l'utilisateur dans la session wensocket
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}

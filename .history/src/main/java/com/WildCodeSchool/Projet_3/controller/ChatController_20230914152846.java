package com.WildCodeSchool.Projet_3.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WildCodeSchool.Projet_3.dto.UserDto;
import com.WildCodeSchool.Projet_3.entity.ChatMessage;
import com.WildCodeSchool.Projet_3.utility.ApiResponse;

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

    @PostMapping("/login")
  @ResponseBody
  public ResponseEntity<ApiResponse<Object>> login(@RequestBody UserDto user) {
    HashMap<String, Object> data = new HashMap<>();
    try {
      userService.login(user);
      String token = jwtUtilService.generateToken(user);
      data.put("user", user);
      data.put("token", token);
      System.out.println("==================== loggin ok: " + user);
      return new ResponseEntity<>(new ApiResponse<>(data), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }
    // @MessageMapping("/addUser")
    // @SendTo("/topic/public")
    // public ChatMessage addUser(
    //         @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor
            
    // ) {   
    //       // ajout de l'utilisateur dans la session wensocket
    //     headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    //     return chatMessage;
    // }
}

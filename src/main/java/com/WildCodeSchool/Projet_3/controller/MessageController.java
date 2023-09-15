package com.WildCodeSchool.Projet_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.WildCodeSchool.Projet_3.entity.Message;
import com.WildCodeSchool.Projet_3.repository.MessageRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")


public class MessageController {


    @Autowired

    private MessageRepository messageRepository;

    @PostMapping("/send-message/{messageInfo}")
    @ResponseBody
        public  ResponseEntity<?>sendMessage(@PathVariable String messageInfo) {
            Message message = new Message();
            System.out.println(message);
        if (messageInfo == "") {
            return ResponseEntity.badRequest().body("Message is empty");
        }
        messageRepository.save(message);
        
    return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}

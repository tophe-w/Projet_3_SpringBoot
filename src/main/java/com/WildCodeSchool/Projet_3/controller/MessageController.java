package com.WildCodeSchool.Projet_3.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.WildCodeSchool.Projet_3.entity.Message;
import com.WildCodeSchool.Projet_3.entity.UserEntity;
import com.WildCodeSchool.Projet_3.repository.MessageRepository;
import com.WildCodeSchool.Projet_3.utility.ApiResponse;

@Controller
@CrossOrigin(origins = "http://localhost:4200")

public class MessageController {
    @Autowired

    private MessageRepository messageRepository;


    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    

    @PostMapping("/send-message")
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> sender(@RequestBody Message messageSend) {
           Message message = new Message();
        try {

            message.setMessage(messageSend.getMessage());
            message.setUser(messageSend.getUser());
            messageRepository.save(message);
            

            return new ResponseEntity<>(new ApiResponse<>(message), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/all-messages")
    @ResponseBody
    public List<Message> getAllMessages() {
          List<Message> messageList = messageRepository.findAll();
        return messageList;
    }


    



}

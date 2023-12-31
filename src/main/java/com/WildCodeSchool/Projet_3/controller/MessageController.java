package com.WildCodeSchool.Projet_3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WildCodeSchool.Projet_3.entity.Message_Main;
import com.WildCodeSchool.Projet_3.entity.Message_Mp;
import com.WildCodeSchool.Projet_3.entity.Message_global;
import com.WildCodeSchool.Projet_3.entity.UserEntity;

import com.WildCodeSchool.Projet_3.repository.Message_mpRepository;
import com.WildCodeSchool.Projet_3.repository.Message_globalRepository;
import com.WildCodeSchool.Projet_3.repository.Message_mainRepository;
import com.WildCodeSchool.Projet_3.repository.UserRepository;
import com.WildCodeSchool.Projet_3.utility.ApiResponse;

@RestController

@CrossOrigin(origins = {"http://192.168.1.51:4200", "http://localhost:4200","https://sncf-companion.online","https://www.sncf-companion.online","http://sncf-companion.online","http://www.sncf-companion.online"})

public class MessageController {
    @Autowired

    private Message_mainRepository main_chatRepository;
    private UserRepository userRepository;
    private Message_mpRepository mp_chatRepository;
    private Message_globalRepository global_chatRepository;


    public MessageController( Message_mainRepository main_chatRepository, UserRepository userRepository, Message_mpRepository mp_chatRepository, Message_globalRepository global_chatRepository) {
        this.main_chatRepository = main_chatRepository;
        this.userRepository = userRepository;
        this.mp_chatRepository = mp_chatRepository;
        this.global_chatRepository = global_chatRepository;
    }
    

    // envoie et récupération des messages de la room global



@PostMapping("/send-message-global/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> sender(@RequestBody Message_global messageSend, @PathVariable int id) {
           Message_global message = new Message_global();
        try {
            UserEntity user = userRepository.findById(id).orElse(null);


            
            message.setMessage(messageSend.getMessage());
            message.setHeure(messageSend.getHeure());
            message.setDate(messageSend.getDate());
            message.setUser_id(user);
            

            
                global_chatRepository.save(message);
            
            

            return new ResponseEntity<>(new ApiResponse<>(message), HttpStatus.OK);
        } catch (Exception e) {
            
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/all-messages-global/{size}")
    @ResponseBody
    public List<Message_global> getAllMessagesGlobal(@PathVariable long size) {
          List<Message_global> messageList = global_chatRepository.findAll();
            if (messageList.size() > size) {
                return messageList;
            } else {
                return null;
            }


        
    }




    // envoie et récupération des messages de la room mp 



@PostMapping("/send-message-mp/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> sender(@RequestBody Message_Mp messageSend, @PathVariable int id) {
           Message_Mp message = new Message_Mp();
        try {
            UserEntity user = userRepository.findById(id).orElse(null);

            
            message.setMessage(messageSend.getMessage());
            message.setHeure(messageSend.getHeure());
            message.setUserReceiver(messageSend.getUserReceiver());
            message.setUserReceiverName(messageSend.getUserReceiverName());
            message.setUser(user);
            

            
                mp_chatRepository.save(message);
            
            

            return new ResponseEntity<>(new ApiResponse<>(message), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/all-messages-mp")
    @ResponseBody
    public List<Message_Mp> getAllMessagesMp() {
          List<Message_Mp> messageList = mp_chatRepository.findAll();
        return messageList;
    }












    // envoie et récupération des messages de la room main et suppression des messages de la room main

    @PostMapping("/send-message-main/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> sender(@RequestBody Message_Main messageSend, @PathVariable int id) {
           Message_Main message = new Message_Main();
        try {
            UserEntity user = userRepository.findById(id).orElse(null);

            
            message.setMessage(messageSend.getMessage());
            message.setHeure(messageSend.getHeure());
            message.setRoomName(messageSend.getRoomName());
            message.setUser(user);
            

            
                main_chatRepository.save(message);
            
            

            return new ResponseEntity<>(new ApiResponse<>(message), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/all-messages-main")
    @ResponseBody
    public List<Message_Main> getAllMessagesMain() {
          List<Message_Main> messageList = main_chatRepository.findAll();
        return messageList;
    }

    @DeleteMapping("/message/main/{id}")
    @ResponseBody
    public void deleteMessageMain(@PathVariable Integer id) {
        main_chatRepository.deleteById(id);
    }


}

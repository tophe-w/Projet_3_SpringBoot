package com.WildCodeSchool.Projet_3.controller;

import com.WildCodeSchool.Projet_3.EmailNotificationService;
import com.WildCodeSchool.Projet_3.entity.EmailRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private EmailNotificationService emailService;

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        String subject = emailRequest.getSubject();
        String body = "From: " + emailRequest.getEmail() + "\n\n" + emailRequest.getBody();
        emailService.sendEmail(subject, body);
    }
}


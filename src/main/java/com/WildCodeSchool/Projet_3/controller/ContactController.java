package com.WildCodeSchool.Projet_3.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@RestController
@RequestMapping("/api")
public class ContactController {
    private final MailSender mailSender;

    public ContactController(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
//     @PostMapping("/send-email")
//     public void sendEmail(@RequestBody EmailRequest emailRequest) {
//         SimpleMailMessage mailMessage = new SimpleMailMessage();
//         mailMessage.setTo("votre@email.com");
//         mailMessage.setSubject("Nouveau message de l'utilisateur");
//         mailMessage.setText(emailRequest.getMessage());
//         mailSender.send(mailMessage);
//     }
// }

// }

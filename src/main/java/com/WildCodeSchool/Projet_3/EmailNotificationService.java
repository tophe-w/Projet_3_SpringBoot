package com.WildCodeSchool.Projet_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    
    // C'est ici qu'il faut mettre l'adresse mail de l'expéditeur que l'on a créé sur le serveur dans le fichier application.properties

    @Value("${spring.mail.username}")
    private String fromEmail;

    // C'est ici qu'il faut mettre l'adresse mail du destinataire que l'on a créé sur le serveur dans le fichier application.properties
    
    @Value("${email.to}")
    private String toEmail;

    public void sendEmail(String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

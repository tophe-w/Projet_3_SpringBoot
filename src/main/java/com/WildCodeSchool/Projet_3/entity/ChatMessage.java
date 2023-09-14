package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



  @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder

    @Entity
public class ChatMessage {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String content;
        private String sender;
        private MessageType type;
}

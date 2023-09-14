package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WildCodeSchool.Projet_3.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
    
}

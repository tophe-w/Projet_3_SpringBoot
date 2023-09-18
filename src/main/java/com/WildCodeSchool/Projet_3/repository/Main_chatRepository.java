package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WildCodeSchool.Projet_3.entity.Main_chat;


@Repository
public interface Main_chatRepository extends JpaRepository<Main_chat, Integer> {
    
}

package com.WildCodeSchool.Projet_3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.WildCodeSchool.Projet_3.entity.Message;
import com.WildCodeSchool.Projet_3.entity.UserEntity;



public interface MessageRepository extends JpaRepository<Message, Integer> {

 
   
    void save(String message);
}

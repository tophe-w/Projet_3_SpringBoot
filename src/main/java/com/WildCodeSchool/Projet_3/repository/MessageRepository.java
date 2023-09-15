package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.WildCodeSchool.Projet_3.entity.Message;



public interface MessageRepository extends JpaRepository<Message, String> {

    

    
}

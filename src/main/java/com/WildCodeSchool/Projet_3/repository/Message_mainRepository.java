package com.WildCodeSchool.Projet_3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.WildCodeSchool.Projet_3.entity.Message_Main;
import com.WildCodeSchool.Projet_3.entity.UserEntity;



public interface Message_mainRepository extends JpaRepository<Message_Main, Integer> {

    Optional<Message_Main> findByRoomName(String string);
    
}

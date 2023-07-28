package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.WildCodeSchool.Projet_3.entity.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    
}

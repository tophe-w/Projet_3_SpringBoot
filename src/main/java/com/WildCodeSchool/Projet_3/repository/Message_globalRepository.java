package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WildCodeSchool.Projet_3.entity.Message_global;

public interface Message_globalRepository extends JpaRepository<Message_global, Integer> {
    
}

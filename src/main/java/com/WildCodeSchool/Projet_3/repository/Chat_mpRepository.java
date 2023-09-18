package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WildCodeSchool.Projet_3.entity.Chat_mp;

@Repository
public interface Chat_mpRepository extends JpaRepository<Chat_mp, Integer> {
    
}

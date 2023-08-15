package com.WildCodeSchool.Projet_3.repository;

import com.WildCodeSchool.Projet_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {
    
}

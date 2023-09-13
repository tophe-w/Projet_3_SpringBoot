package com.WildCodeSchool.Projet_3.repository;

import com.WildCodeSchool.Projet_3.entity.UserEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    Optional<UserEntity> findByUsername(String string);
    Optional<UserEntity> findByEmail(String string);
    Optional<UserEntity> setAvatar id);


}

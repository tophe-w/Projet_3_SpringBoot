package com.WildCodeSchool.Projet_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.WildCodeSchool.Projet_3.repository.UserRepository;

@SpringBootApplication
public class Projet3Application {

	@Autowired
	UserRepository userRepository;



	public static void main(String[] args) {
		SpringApplication.run(Projet3Application.class, args);
	}

}

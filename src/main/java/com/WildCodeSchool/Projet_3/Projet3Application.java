package com.WildCodeSchool.Projet_3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;



@SpringBootApplication
public class Projet3Application {


	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		String secretKey = dotenv.get("SECRET_KEY");
		System.out.println("SECRET_KEY: " + secretKey);
		SpringApplication.run(Projet3Application.class, args);
	}

}

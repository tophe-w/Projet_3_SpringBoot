package com.WildCodeSchool.Projet_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.WildCodeSchool.Projet_3.entity.User;
import com.WildCodeSchool.Projet_3.repository.UserRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create_user")    
@ResponseBody
public User createUser(@RequestBody User user) {
    return userRepository.save(user);
}

    @GetMapping("/user/{id}")//Explique moi à quoi sert @GetMapping ??} 
@ResponseBody
public User getUser(@PathVariable Integer id) {   //Si jamais il y a un problème, essayer peut être de modifier 'Integer' en 'Long'. A la base c'était 'Long' mais ça ne marchait pas avec 'findById'..
    return userRepository.findById(id).orElse(null);
}

}
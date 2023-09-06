package com.WildCodeSchool.Projet_3.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.WildCodeSchool.Projet_3.dto.UserDto;
import com.WildCodeSchool.Projet_3.entity.UserEntity;
import com.WildCodeSchool.Projet_3.jwt.JwtUtil;
import com.WildCodeSchool.Projet_3.repository.UserRepository;
import com.WildCodeSchool.Projet_3.service.UserService;
import com.WildCodeSchool.Projet_3.utility.ApiResponse;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @Autowired

    private UserRepository userRepository;

   private UserService userService;
  private JwtUtil jwtUtilService;

  public UserController(UserService userService, JwtUtil jwtUtilService) {
    this.userService = userService;
    this.jwtUtilService = jwtUtilService;
  }

  @PostMapping("/register")
  @ResponseBody
  public ResponseEntity<ApiResponse<Object>> register(@RequestBody UserDto user) {
    HashMap<String, Object> data = new HashMap<>();
    try {

      userService.register(user);
      String token = jwtUtilService.generateToken(user);
      data.put("user", user);
      data.put("token", token);
      return new ResponseEntity<>(new ApiResponse<>(data), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/login")
  @ResponseBody
  public ResponseEntity<ApiResponse<Object>> login(@RequestBody UserDto user) {
    HashMap<String, Object> data = new HashMap<>();
    try {
      userService.login(user);
      String token = jwtUtilService.generateToken(user);
      data.put("user", user);
      data.put("token", token);
      return new ResponseEntity<>(new ApiResponse<>(data), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(new ApiResponse<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }


  @GetMapping("/user/{id}")

@ResponseBody

public UserEntity getUser(@PathVariable Integer id) {   //Si jamais il y a un problème, essayer peut être de modifier 'Integer' en 'Long'. A la base c'était 'Long' mais ça ne marchait pas avec 'findById'..

    return userRepository.findById(id).orElse(null);

}


@GetMapping("/admin/users")
    @ResponseBody
    public List<UserEntity> getUsers() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @PutMapping("/admin/users/{id}/role")
    @ResponseBody
    public ResponseEntity<?> updateUserRole(@PathVariable Integer id, @RequestBody UserEntity user) {
        UserEntity userToUpdate = userRepository.findById(id).orElse(null);
        
        if (userToUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
    
        // Vérifiez que le nouvel ID de rôle est soit 1 (Admin) soit 2 (User)
        if (user.getRole().getId() == 1 || user.getRole().getId() == 2) {
            userToUpdate.setRole(user.getRole());
            userRepository.save(userToUpdate);
            return ResponseEntity.ok().build(); // Mise à jour réussie
        } else {
            return ResponseEntity.badRequest().body("ID de rôle invalide."); // ID de rôle incorrect
        }
    }

    @GetMapping("/account")
    @ResponseBody
    public List<UserEntity> getUsersData() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @PutMapping("/admin/users/{id}/account")
    @ResponseBody
    public ResponseEntity<?> updateUserAccount(@PathVariable Integer id, @RequestBody UserEntity user) {
        UserEntity userToUpdate = userRepository.findById(id).orElse(null);
        
        if (userToUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
    
        // Vérifiez que le nouvel ID de rôle est soit 1 (Admin) soit 2 (User)
        if (user.getRole().getId() == 1 || user.getRole().getId() == 2) {
            userToUpdate.setRole(user.getRole());
            userRepository.save(userToUpdate);
            return ResponseEntity.ok().build(); // Mise à jour réussie
        } else {
            return ResponseEntity.badRequest().body("ID de rôle invalide."); // ID de rôle incorrect
        }
    }

}
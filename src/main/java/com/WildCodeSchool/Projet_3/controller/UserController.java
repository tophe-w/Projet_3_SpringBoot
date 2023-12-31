package com.WildCodeSchool.Projet_3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WildCodeSchool.Projet_3.dto.UserDto;
import com.WildCodeSchool.Projet_3.entity.UserEntity;
import com.WildCodeSchool.Projet_3.jwt.JwtUtil;
import com.WildCodeSchool.Projet_3.repository.UserRepository;
import com.WildCodeSchool.Projet_3.service.UserService;
import com.WildCodeSchool.Projet_3.utility.ApiResponse;

@RestController
@CrossOrigin(origins = {"http://192.168.1.51:4200", "http://localhost:4200", "https://sncf-companion.online","https://www.sncf-companion.online","http://sncf-companion.online","http://www.sncf-companion.online"})
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
      data.put("id", Integer.toString(user.setId(user.getId())));
      return new ResponseEntity<>(new ApiResponse<>(data), HttpStatus.OK);
    } catch (Exception e) {
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

    @DeleteMapping("/admin/users/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        UserEntity userToDelete = userRepository.findById(id).orElse(null);
        
        if (userToDelete == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
        userRepository.delete(userToDelete);
        return ResponseEntity.ok().build(); // Suppression réussie
    }

    @GetMapping("/account")
    @ResponseBody
    public List<UserEntity> getUsersData() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }




    @PutMapping("/users/{id}/account/avatar/{avatar}")
    @ResponseBody
    public ResponseEntity<?> updateUserAvatarAccount(@PathVariable Integer id, @PathVariable String avatar) {
        UserEntity avatarUpdate = userRepository.findById(id).orElse(null);

        if (avatarUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
          if(avatarUpdate.getAvatar() != avatar){
              avatarUpdate.setAvatar(avatar);
              userRepository.save(avatarUpdate);
          }
        
          return ResponseEntity.ok().build();
      }


      @PutMapping("/users/{id}/account/color/{color}")
    @ResponseBody
    public ResponseEntity<?> updateUserColorAccount(@PathVariable Integer id, @PathVariable String color) {
        UserEntity colorUpdate = userRepository.findById(id).orElse(null);

        if (colorUpdate == null) {
          
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
          if(colorUpdate.getColor() != color){
              colorUpdate.setColor(color);
              userRepository.save(colorUpdate);
          }
        return ResponseEntity.ok().build();
      }
    
      @PutMapping("/users/{id}/account/dispo/{dispo}")
    @ResponseBody
    public ResponseEntity<?> updateUserdispoAccount(@PathVariable Integer id, @PathVariable Boolean dispo) {
        UserEntity dispoUpdate = userRepository.findById(id).orElse(null);
        

        if (dispoUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
          if(dispo == true){
              dispoUpdate.setIs_available(true);
              userRepository.save(dispoUpdate);
          }
          else if(dispo == false){
            dispoUpdate.setIs_available(false);
            userRepository.save(dispoUpdate);
          }
          
        return ResponseEntity.ok().build();
      }

      @PutMapping("/users/{id}/account/online/{online}")
    @ResponseBody
    public ResponseEntity<?> updateUserdonlineAccount(@PathVariable Integer id, @PathVariable Boolean online) {
        UserEntity onlineUpdate = userRepository.findById(id).orElse(null);
        

        if (onlineUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
          if(online == true){
              onlineUpdate.setIs_connected(true);
              userRepository.save(onlineUpdate);
              
          }
          else if(online == false){
            onlineUpdate.setIs_connected(false);
            userRepository.save(onlineUpdate);
          }
          
        return ResponseEntity.ok().build();
      }
    

      @PutMapping("/users/{id}/pseudo/{pseudo}")
    @ResponseBody
    public ResponseEntity<?> updateUserPseudo(@PathVariable Integer id, @PathVariable String pseudo) {
        UserEntity pseudoUpdate = userRepository.findById(id).orElse(null);
        

        if (pseudoUpdate == null) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }
          if(pseudo != ""){
              pseudoUpdate.setUsername(pseudo);
              userRepository.save(pseudoUpdate);
              
          }
          
        return ResponseEntity.ok().build();
      }

}
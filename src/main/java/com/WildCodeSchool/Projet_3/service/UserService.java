package com.WildCodeSchool.Projet_3.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.WildCodeSchool.Projet_3.dto.UserDto;
import com.WildCodeSchool.Projet_3.entity.Role;
import com.WildCodeSchool.Projet_3.entity.UserEntity;
import com.WildCodeSchool.Projet_3.repository.RoleRepository;
import com.WildCodeSchool.Projet_3.repository.UserRepository;


@Service
public class UserService {
  // On vérifie si il y 'a un mdp
  // On vérifie si le mdp est assez fort (regex)
  // On vérifie si l'adrresse email n'existe pas déja dans la base de donnée
  private RoleRepository roleRepository;
  private UserRepository userRepository;
  private BCryptPasswordEncoder bcryptEncoder;

  public UserService(RoleRepository roleRepository, UserRepository userRepository,
      BCryptPasswordEncoder bcryptEncoder) {
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
    this.bcryptEncoder = bcryptEncoder;
  }

  public boolean checkHashedPassword(String password) {
    // Réelle implémantation à mettre en place vous même
    return true;
  }

  public boolean checkEmail(String email) {
    // Réelle implémantation à mettre en place vous même
    return true;
  }

  public UserDto register(UserDto user) {
    if (!checkHashedPassword(user.getPassword())) {
      throw new RuntimeException("Le mot de passe n'est pas assez fort");
    }
    if (!checkEmail(user.getEmail())) {
      throw new RuntimeException("L'email existe déja");
    }

    String hashedpassword = bcryptEncoder.encode(user.getPassword());

    Role userRole = roleRepository.findById(2L).get();
    UserEntity newUser = new UserEntity(user.getName(),hashedpassword,false,user.getEmail(),userRole,user.getBirthday(),user.getFirstname(),user.getUsername(),"arbre.png","",false);
    user.setRole(userRole.getType());
    userRepository.save(newUser);
    return user;
  }



  // ############## LOGIN #####################
  public boolean verifyHashedPasswordDuringLogin(String password, String hashedPassword) {
    
    return bcryptEncoder.matches(password, hashedPassword);
    
  }

  public UserEntity getUserEntityByEmail(String email) {
    try {
      return userRepository.findByEmail(email).get();
    } catch (Exception e) {
      throw new RuntimeException("L'email n'existe pas");
    }
  }


  public UserDto login(UserDto user) {
    UserEntity userEntity = getUserEntityByEmail(user.getEmail());
    if (!verifyHashedPasswordDuringLogin(user.getPassword(), userEntity.getPassword())) {
      throw new RuntimeException("Le mot de passe est incorrect");
    }
    user.setRole(userEntity.getRole().getType());
    user.setUsername(userEntity.getUsername());
    user.setId(userEntity.getId());
    
    
    return user;
  }



}

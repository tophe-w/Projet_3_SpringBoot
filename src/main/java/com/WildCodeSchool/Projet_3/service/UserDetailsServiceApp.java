package com.WildCodeSchool.Projet_3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.WildCodeSchool.Projet_3.jwt.UserPrincipal;
import com.WildCodeSchool.Projet_3.repository.UserRepository;

@Component
public class UserDetailsServiceApp implements UserDetailsService {

  private UserRepository userRepository;

  public UserDetailsServiceApp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new UserPrincipal(userRepository.findByUsername(username).get());
  }
}


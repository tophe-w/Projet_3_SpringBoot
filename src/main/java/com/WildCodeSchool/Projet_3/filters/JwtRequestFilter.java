package com.WildCodeSchool.Projet_3.filters;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.WildCodeSchool.Projet_3.jwt.JwtUtil;
import com.WildCodeSchool.Projet_3.service.UserDetailsServiceApp;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  private JwtUtil jwtUtilService;
  private UserDetailsServiceApp userDetailsService;

  public JwtRequestFilter(JwtUtil jwtUtileService, UserDetailsServiceApp userDetailsService) {
    this.jwtUtilService = jwtUtileService;
    this.userDetailsService = userDetailsService;
  }
  


  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain
  ) throws ServletException, IOException {
    final String authorizationHeader = request.getHeader("Authorization");

    String username = null;
    String token = null;

    // ############### 1. Récupération du token et du username dans le header ################
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
    
      token = authorizationHeader.substring(7);
      
      username = jwtUtilService.extractUsername(token);
    }
    

    // ############### 2. Vérification du token ################
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
      
     

      if (token != null && userDetails != null) {
        // UsernamePasswordAuthenticationToken est un container qui va contenir les informations de l'utilisateur dans le contexte de sécurité 
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
          userDetails, // Le User
          null, // Le mdp mais pas besoin ici
          userDetails.getAuthorities() // les Rôles
        );

        usernamePasswordAuthenticationToken.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );
        // On ajoute UsernamePasswordAuthenticationToken dans le contexte de sécurité juste ici avec le set
        SecurityContextHolder
          .getContext()
          .setAuthentication(usernamePasswordAuthenticationToken);
      }
    }
    chain.doFilter(request, response);
  }

}


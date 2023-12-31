package com.WildCodeSchool.Projet_3.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.WildCodeSchool.Projet_3.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final JwtRequestFilter jwtRequestFilter;

  public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
    this.jwtRequestFilter = jwtRequestFilter;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Bean
  // public UserDetailsService userDetailsService(UserRepository userRepository) {
  //   return new UserDetailsService() {
  //     @Override
  //     public UserDetails loadUserByUsername(String username) {
  //       UserEntity user = userRepository.findByUsername(username).get();
  //       System.out.println("@@@@@ " + user.getRole());
  //       return user.asUserDetails();
  //     }
  //   };
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/register", "/login", "/user/{id}","admin/users","/account", "/admin/users/{id}/role","/admin/users/{id}/account").permitAll()
            .requestMatchers("/logout", "/user-admin-data").hasAnyAuthority("USER", "ADMIN")
            .requestMatchers("/admin", "/only-admin-data").hasAuthority("ADMIN")
            .requestMatchers("/other_routes_example/**")
            .authenticated())
        .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // You can disable csrf protection by removing this line
            .ignoringRequestMatchers("/register", "/login")
            .disable()  // Décommentez pour désactiver en entier la protection CSRF en développement
            )
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)// Spring Security ne crée pas de session
        // Nous allons utiliser JWT pour gérer les sessions
        );
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build(); // Très important de retourner le résultat de la méthode build() !
    // Sinon rien de tout ça ne fonctionne !
  }
}

/**
 * 
 * What is a CSRF Token?
 * A CSRF token (Cross-Site Request Forgery token) is a unique and unpredictable
 * value that's generated by the server and included as part of requests that
 * might change data. This token ensures that the request was intentionally made
 * by the authenticated user and not by a malicious site on their behalf.
 * 
 * Why Do You Need It?
 * 
 * Imagine you're logged into your online bank account. A malicious website
 * tricks you into clicking a link that requests a money transfer from your bank
 * account. Without CSRF protection, your bank might treat this as a legitimate
 * request since you're already logged in.
 * 
 * But with CSRF protection, every request that can change data (like
 * transferring money) requires a CSRF token. Since the malicious site won't
 * know this token, the request would fail.
 * 
 * So, in simple terms, a CSRF token protects you by ensuring that only
 * legitimate requests made by you are processed by the server.
 */

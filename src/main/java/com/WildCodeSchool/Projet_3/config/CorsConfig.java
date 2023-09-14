package com.WildCodeSchool.Projet_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // Remplacez par l'URL de votre application Angular
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}



// @Override
// public void addCorsMappings(CorsRegistry registry) {
//     registry.addMapping("/**") 
//         .allowedOrigins("http://localhost:4200") 
//         .allowedMethods("GET", "POST", "PUT", "DELETE")
//         .allowedHeaders("*");
// }

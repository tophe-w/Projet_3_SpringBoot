package com.WildCodeSchool.Projet_3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
            // .allowedOrigins("http://localhost:4200")
            .allowedOrigins("http://192.168.1.51:4200","https://sncf-companion.online","https://www.sncf-companion.online","http://sncf-companion.online","http://www.sncf-companion.online") 
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
    }
}



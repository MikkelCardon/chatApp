package com.ChatApp.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")          // Allow all paths
                .allowedOrigins("*")        // Allow all origins
                .allowedMethods("*")        // Allow all HTTP methods
                .allowedHeaders("*");       // Allow all headers
    }
}


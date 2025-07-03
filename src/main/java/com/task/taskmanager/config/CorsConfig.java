package com.task.taskmanager.config;

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

        // Allow requests from Angular frontend
        config.setAllowCredentials(true); // Allow cookies or credentials if needed
        config.addAllowedOrigin("http://localhost:4200"); // Specify your frontend origin
        config.addAllowedHeader("*"); // Allow all headers
     config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, OPTIONS, etc.)

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
package com.am.backend;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .requestMatchers("").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/*").permitAll()
                .requestMatchers("/**").permitAll();
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();

//        //configuration.setAllowedOrigins(ImmutableList.of("https://www.yourdomain.com")); // www - obligatory
//        configuration.setAllowedOrigins(List.of("*"));  //set access from all domains
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type", "*"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}

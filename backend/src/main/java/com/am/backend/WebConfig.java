package com.am.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/bilde/**", "/qem/**")
                .addResourceLocations("file:///C:/Users/Ansis/IdeaProjects/bilde/", "file:///C:/Users/Ansis/IdeaProjects/quincyessentialmusic/");
    }
}
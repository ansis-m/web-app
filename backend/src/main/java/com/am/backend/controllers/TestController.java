package com.am.backend.controllers;

import com.am.backend.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@CrossOrigin
public class TestController {


    @Value("${hostname}")
    private String hostname;

    @Autowired
    private ApplicationContext context;
    @GetMapping("/test")
    public TestModel test(){
        System.out.println("~~~~~~~~~~~request from the frontend~~~~~~~~~~~\n");
        System.out.println("hostname: " + hostname + "\n\n");
        return new TestModel();
    }

    @GetMapping("/quit")
    public void quit(){
        SpringApplication.exit(context, () -> 0);
    }
}

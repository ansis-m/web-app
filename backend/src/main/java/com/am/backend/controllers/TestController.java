package com.am.backend.controllers;

import com.am.backend.models.TestModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class TestController {
    @GetMapping("/test")
    public TestModel test(){
        return new TestModel();
    }
}

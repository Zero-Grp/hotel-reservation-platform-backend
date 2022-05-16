package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping(path = "/message")
    public String message() {
        return "Hello World";
    }

}

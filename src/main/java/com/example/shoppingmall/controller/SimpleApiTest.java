package com.example.shoppingmall.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleApiTest {

    @GetMapping("/api/hello")
    public String test(){
        return "Hello, World";
    }
}

package com.ani.practice.springdataexercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @GetMapping("/hi")
    public String keepLiv() {
        return  "hello";
    }
}

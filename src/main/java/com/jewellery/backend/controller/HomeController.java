package com.jewellery.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    @GetMapping("/")
    public String home() {
        return "Welcome to Sri Laxmi Narayana Jewellery Store";
    }
}

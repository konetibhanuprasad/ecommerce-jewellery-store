package com.jewellery.backend.controller;

import com.jewellery.backend.dto.RegisterRequest;
import com.jewellery.backend.entity.User;
import com.jewellery.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.jewellery.backend.dto.LoginRequest;
import com.jewellery.backend.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    // Constructor Injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        return userService.loginUser(request);

    }
}
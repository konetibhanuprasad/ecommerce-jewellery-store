package com.jewellery.backend.service;

import com.jewellery.backend.entity.User;
import com.jewellery.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jewellery.backend.exception.EmailAlreadyExistsException;
import com.jewellery.backend.dto.LoginRequest;
import com.jewellery.backend.dto.LoginResponse;
import org.springframework.security.authentication.BadCredentialsException;
import com.jewellery.backend.security.jwt.JwtService;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // -----------------------------
    // Registration Method
    // -----------------------------
    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        user.setRole("CUSTOMER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // -----------------------------
    // ADD THIS METHOD HERE
    // -----------------------------
    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        System.out.println("Entered Email : " + request.getEmail());
        System.out.println("Entered Password : " + request.getPassword());
        System.out.println("Stored Password : " + user.getPassword());

        boolean match = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        System.out.println("Password Match : " + match);

        if (!match) {
            throw new BadCredentialsException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token, "Login Successful");
    }

}
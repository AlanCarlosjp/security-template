package com.example.oauth2resourceserver.controller;

import com.example.oauth2resourceserver.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {

    private final TokenService service;

    public AuthController(TokenService service) {
        this.service = Objects.requireNonNull(service);
    }

    @PostMapping(value = "token")
    public ResponseEntity<?> token(Authentication auth){
        return ResponseEntity.ok().body(service.generateToken(auth));
    }

}

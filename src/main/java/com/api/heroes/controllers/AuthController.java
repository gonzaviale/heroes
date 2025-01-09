package com.api.heroes.controllers;

import com.api.heroes.models.DTO.LoginDTO;
import com.api.heroes.models.DTO.RegisterDTO;
import com.api.heroes.models.DTO.TokenDTO;
import com.api.heroes.models.UserModel;
import com.api.heroes.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenDTO> register(@RequestBody final RegisterDTO register) {
        final TokenDTO token = authService.register(register);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody final LoginDTO login) {
        final TokenDTO token = authService.login(login);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/refresh")
    public TokenDTO refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authHeader) {
        return authService.refreshToken(authHeader);
    }
}

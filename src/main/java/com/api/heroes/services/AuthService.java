package com.api.heroes.services;

import com.api.heroes.models.DTO.LoginDTO;
import com.api.heroes.models.DTO.RegisterDTO;
import com.api.heroes.models.DTO.TokenDTO;
import com.api.heroes.models.TokenModel;
import com.api.heroes.models.UserModel;
import com.api.heroes.repositories.ITokenRepository;
import com.api.heroes.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final ITokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenDTO register(RegisterDTO dto) {
        var user = UserModel.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return new TokenDTO(jwtToken, refreshToken);
    }

    public TokenDTO login(LoginDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        var user = userRepository.findByUsername(dto.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return new TokenDTO(jwtToken, refreshToken);
    }

    public TokenDTO refreshToken(final String authHeader) {
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Refresh token is missing");
        }
        final String refreshToken = authHeader.substring(7);
        final String username = jwtService.extractUsername(refreshToken);

        if (username == null) {
            throw new IllegalArgumentException("Refresh token is invalid");
        }

        final UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        if (jwtService.isTokenValid(refreshToken, user)) {
            final String accessToken = jwtService.generateToken(user);
            revokeAllUserTokens(user);
            saveUserToken(user, accessToken);
            return new TokenDTO(accessToken, refreshToken);
        } else {
            throw new RuntimeException("Refresh token is expired");
        }
    }

    private void revokeAllUserTokens(UserModel user) {
        final List<TokenModel> validUserTokens = tokenRepository.findAllValidTokenByUser(user);
        if (!validUserTokens.isEmpty()){
            for (final TokenModel token : validUserTokens) {
                token.setExpired(true);
                token.setRevoked(true);
            }
            tokenRepository.saveAll(validUserTokens);
        }
    }

    private void saveUserToken(UserModel user, String jwtToken) {
        var token = TokenModel.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenModel.TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

}

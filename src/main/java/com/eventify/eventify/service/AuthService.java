package com.eventify.eventify.service;

import com.eventify.eventify.dto.LoginRequest;
import com.eventify.eventify.dto.LoginResponse;
import com.eventify.eventify.model.User;
import com.eventify.eventify.repository.UserRepository;
import com.eventify.eventify.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String token = jwtService.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponse(token);
    }
}
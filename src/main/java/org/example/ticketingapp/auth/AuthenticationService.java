package org.example.ticketingapp.auth;


import lombok.RequiredArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.entity.Role;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.IllegalResourceException;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public boolean findUser(String email) {
        return repository.existsByEmail(email);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new DataIntegrityViolationException("User already exists: " + request.getEmail());
        }
        Role role = switch (request.getRole()) {
            case "vendor" -> Role.VENDOR;
            case "customer" -> Role.CUSTOMER;
            case "admin" -> Role.ADMIN;
            default -> throw new IllegalResourceException("Invalid role: " + request.getRole());
        };

        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(request.getEmail())
                .role(user.getRole().name())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("No such user found"));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}

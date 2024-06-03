package com.example.beambackend.auth;

import com.example.beambackend.dto.AuthResponse;
import com.example.beambackend.dto.LoginRequest;
import com.example.beambackend.dto.RegisterRequest;
import com.example.beambackend.security.JwtService;
import com.example.beambackend.user.User;
import com.example.beambackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        return new AuthResponse(jwtService.generateToken(loginRequest.email()));
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        userRepository.save(new User(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.email(),
                registerRequest.password()

        ));
        return new AuthResponse(jwtService.generateToken(registerRequest.email()));
    }
}

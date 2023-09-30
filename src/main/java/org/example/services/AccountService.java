package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.configuration.security.JwtService;
import org.example.dto.account.AuthResponseDTO;
import org.example.dto.account.LoginDTO;
import org.example.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO login(LoginDTO dto) {
        var user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow();
        var isValid = passwordEncoder.matches(dto.getPassword(), user.getPassword());
        if(!isValid)
            throw new UsernameNotFoundException("User not found");

        var jwtToken = jwtService.generateAccessToken(user);
        return AuthResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
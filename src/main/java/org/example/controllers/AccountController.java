package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dto.account.AuthResponseDTO;
import org.example.dto.account.LoginDTO;
import org.example.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login (@RequestBody LoginDTO login){
        try {
            var auth = accountService.login(login);
            return ResponseEntity.ok(auth);
        }catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

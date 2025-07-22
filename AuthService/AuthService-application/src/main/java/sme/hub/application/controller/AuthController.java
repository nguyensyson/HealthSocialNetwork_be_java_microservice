package sme.hub.application.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sme.hub.business.dto.CreateUsersRequest;
import sme.hub.business.dto.LoginRequest;
import sme.hub.business.dto.LoginResponse;
import sme.hub.business.services.UsersService;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody CreateUsersRequest request) {
        usersService.register(request);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(usersService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam("refresh_token") String refreshToken) {
        usersService.logout(refreshToken);
        return ResponseEntity.ok("Logged out successfully");
    }
}

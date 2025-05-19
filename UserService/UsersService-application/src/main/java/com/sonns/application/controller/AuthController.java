package com.sonns.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value = "/register")
    public ResponseEntity<String> register() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }

    @PostMapping(value = "/forgot")
    public ResponseEntity<String> forgotPassword() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }

    @PostMapping(value = "/change")
    public ResponseEntity<String> changePassword() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }
}

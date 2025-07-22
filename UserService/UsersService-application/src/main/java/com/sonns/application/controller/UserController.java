package com.sonns.application.controller;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.business.dto.FollowRequest;
import com.sonns.business.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<String> createProfile(@RequestBody CreateUsersRequest request) {
        boolean response = userService.createUser(request);
        if (response) {
            return ResponseEntity.ok("User created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create user.");
        }
    }

    @GetMapping()
    public ResponseEntity<String> getUserProfile() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }

    @PutMapping()
    public ResponseEntity<String> updateUserProfile(@ModelAttribute FollowRequest request) {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }
}

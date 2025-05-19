package com.sonns.application.controller;

import com.sonns.business.dto.FollowRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/")
    public ResponseEntity<String> getUserProfile() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }

    @PutMapping(value = "/")
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

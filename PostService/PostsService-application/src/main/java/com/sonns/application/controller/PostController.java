package com.sonns.application.controller;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostCreateRequest postRequest) {
        postsService.createPost(postRequest);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PutMapping
    public ResponseEntity<String> updatePost() {
        return ResponseEntity.ok("User updated successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost() {
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping
    public void getAllPosts() {

    }

    @GetMapping("/{id}")
    public void getPostById(@PathVariable Long id) {

    }
}

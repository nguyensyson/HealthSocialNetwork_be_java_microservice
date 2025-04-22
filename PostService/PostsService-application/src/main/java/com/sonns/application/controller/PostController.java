package com.sonns.application.controller;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsResponse;
import com.sonns.business.services.PostsService;
import com.sonns.common.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<String> createPost(@ModelAttribute PostCreateRequest postRequest) {
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
    public ResponseEntity<BaseResponse<Page<PostsResponse>>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PostsResponse> response = postsService.getPosts(page,size);
        return ResponseEntity.ok(BaseResponse.success(response));
    }

    @GetMapping("/{id}")
    public void getPostById(@PathVariable Long id) {

    }
}

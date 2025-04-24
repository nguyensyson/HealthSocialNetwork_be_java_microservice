package com.sonns.application.controller;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostDetailResponse;
import com.sonns.business.dto.PostsResponse;
import com.sonns.business.services.PostsService;
import com.sonns.common.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<String> createPost(@ModelAttribute PostCreateRequest postRequest) {
        boolean response = postsService.createPost(postRequest);
        if (response) {
            return ResponseEntity.ok("User registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create post.");
        }
    }

    @PutMapping(value = "/{postId}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> updatePost(
            @PathVariable String postId,
            @ModelAttribute PostCreateRequest postRequest) {

        boolean response = postsService.updatePost(postId, postRequest);
        if (response) {
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update post.");
        }
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
    public ResponseEntity<BaseResponse<PostDetailResponse>> getPostById(@PathVariable String id) {
        PostDetailResponse response = postsService.getPostDetail(id);
        return ResponseEntity.ok(BaseResponse.success(response));
    }
}

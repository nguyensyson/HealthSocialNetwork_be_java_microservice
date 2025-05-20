package com.sonns.application.controller;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.dto.proxy.UserFollowResponseProxy;
import com.sonns.business.services.FollowService;
import com.sonns.common.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping(value = "/")
    public ResponseEntity<String> follow(@ModelAttribute FollowRequest request) {
        boolean response = followService.follow(request);
        if (response) {
            return ResponseEntity.ok("Follow successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to Follow.");
        }
    }

    @GetMapping(value = "/count/{userId}")
    public ResponseEntity<Integer> countFollow(@PathVariable String userId) {
        Integer response = followService.countFollow(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/follower/{userId}")
    public ResponseEntity<BaseResponse<List<UserFollowResponseProxy>>> follower(@PathVariable String userId) {
        List<UserFollowResponseProxy> response = followService.getFollower(userId);
        return ResponseEntity.ok(BaseResponse.success(response));
    }

    @GetMapping(value = "/following")
    public ResponseEntity<String> following() {
//        boolean response = postsService.createPost(postRequest);
//        if (response) {
        return ResponseEntity.ok("User registered successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create post.");
//        }
    }
}

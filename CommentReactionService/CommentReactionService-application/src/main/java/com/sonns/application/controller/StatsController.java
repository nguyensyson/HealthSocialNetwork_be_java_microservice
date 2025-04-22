package com.sonns.application.controller;

import com.sonns.business.dto.PostStatsResponse;
import com.sonns.business.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stats")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostStatsResponse> getStatsByPostId(@PathVariable String postId) {
        PostStatsResponse stats = statsService.getPostStats(postId);
        return ResponseEntity.ok(stats);
    }
}

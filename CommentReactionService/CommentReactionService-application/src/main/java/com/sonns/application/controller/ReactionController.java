package com.sonns.application.controller;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.business.dto.ReactionRequest;
import com.sonns.business.services.ReactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reaction")
public class ReactionController {

    private ReactionsService reactionsService;

    @PostMapping()
    public ResponseEntity<String> reaction(@RequestBody ReactionRequest request) {
        reactionsService.reactions(request);
        return ResponseEntity.ok("oke");
    }
}

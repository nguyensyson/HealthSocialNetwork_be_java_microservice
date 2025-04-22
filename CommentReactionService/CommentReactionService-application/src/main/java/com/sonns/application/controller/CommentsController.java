package com.sonns.application.controller;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.business.repo.CommentsRepo;
import com.sonns.business.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentsController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<String> addComment(@RequestBody AddCommentRequest request) {
        commentService.addComment(request);
        return ResponseEntity.ok("oke");
    }
}

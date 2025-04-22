package com.sonns.business.services.impl;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.business.repo.CommentsRepo;
import com.sonns.business.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentsRepo commentsRepo;

    @Override
    public void addComment(AddCommentRequest comment) {
        commentsRepo.addComment(comment);
    }
}

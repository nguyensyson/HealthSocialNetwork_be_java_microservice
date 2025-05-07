package com.sonns.business.services;

import com.sonns.business.dto.AddCommentRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    void addComment(AddCommentRequest comment);
    void editComment(String id, AddCommentRequest comment);
    void deleteComment(String id);
}

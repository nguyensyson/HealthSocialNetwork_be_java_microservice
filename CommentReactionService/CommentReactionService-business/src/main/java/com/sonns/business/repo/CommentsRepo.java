package com.sonns.business.repo;

import com.sonns.business.dto.AddCommentRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo {
    Integer countCommentsByPost(String postId);
    void addComment(AddCommentRequest comment);
    void editComment(String id, AddCommentRequest comment);
    void deleteComment(String id);
}

package com.sonns.infratructures.shared;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.business.repo.CommentsRepo;
import com.sonns.infratructures.repository.CommentsResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentsRepoImpl implements CommentsRepo {

    private final CommentsResponsitory commentsResponsitory;

    @Override
    public Integer countCommentsByPost(String postId) {
        Integer commentCount = commentsResponsitory.countByPostId(postId);
        return commentCount;
    }

    @Override
    public void addComment(AddCommentRequest comment) {

    }
}

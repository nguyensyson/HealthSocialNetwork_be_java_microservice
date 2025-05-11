package com.sonns.business.repo;

import com.sonns.business.dto.ReactionDto;
import com.sonns.business.dto.ReactionRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionsRepo {
    Integer countLikesByPost(String postId);
    ReactionDto findByPostIdAndUserId(String postId, String userId);
    ReactionDto findByCommentIdAndUserId(String postId, String userId);
    void save(ReactionRequest request);
    void updateActiveReaction(String reactionId);
}

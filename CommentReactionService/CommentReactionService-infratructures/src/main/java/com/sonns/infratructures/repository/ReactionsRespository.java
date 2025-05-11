package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionsRespository extends JpaRepository<Reactions, String> {
    int countByPostId(String postId);
    Reactions getReactionsByPostIdAndUserId(String postId, String userId);
    Reactions getReactionsByCommentIdAndUserId(String commentId, String userId);
}

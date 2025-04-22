package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsResponsitory extends JpaRepository<Comments, String> {
    Integer countByPostId(String postId);
}

package com.sonns.business.repo;

import org.springframework.stereotype.Repository;

@Repository
public interface ReactionsRepo {
    Integer countLikesByPost(String postId);
}

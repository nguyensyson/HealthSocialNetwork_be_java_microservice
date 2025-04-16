package com.sonns.business.repo;

import com.sonns.business.dto.PostCreateRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo {
    void createPost(PostCreateRequest post);
}

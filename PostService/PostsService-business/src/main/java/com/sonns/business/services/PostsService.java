package com.sonns.business.services;

import com.sonns.business.dto.PostCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface PostsService {

    void createPost(PostCreateRequest post);
}

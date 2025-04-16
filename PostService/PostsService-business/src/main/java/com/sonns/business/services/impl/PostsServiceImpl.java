package com.sonns.business.services.impl;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.repo.PostsRepo;
import com.sonns.business.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepo postsRepo;

    @Override
    public void createPost(PostCreateRequest post) {
        postsRepo.createPost(post);
    }
}

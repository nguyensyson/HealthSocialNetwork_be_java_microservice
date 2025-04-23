package com.sonns.business.services;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostsService {

    Boolean createPost(PostCreateRequest post);
    Page<PostsResponse> getPosts(int page, int size);
    Boolean updatePost(String id, PostCreateRequest post);
}

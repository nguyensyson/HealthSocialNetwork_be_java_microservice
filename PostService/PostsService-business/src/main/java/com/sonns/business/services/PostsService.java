package com.sonns.business.services;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostDetailResponse;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.PostsResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostsService {

    Boolean createPost(PostCreateRequest post);
    Page<PostsResponse> getPosts(int page, int size);
    Boolean updatePost(String id, PostCreateRequest post);
    PostDetailResponse getPostDetail(String id);
}

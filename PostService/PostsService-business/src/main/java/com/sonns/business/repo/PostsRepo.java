package com.sonns.business.repo;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.proxy.PostsProxyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo {
    PostsDto createPost(PostCreateRequest post);
    Page<PostsProxyDto> getPosts(Pageable pageable);
    PostsDto getPostById(String id);
    PostsProxyDto getPostDetail(String id);
}

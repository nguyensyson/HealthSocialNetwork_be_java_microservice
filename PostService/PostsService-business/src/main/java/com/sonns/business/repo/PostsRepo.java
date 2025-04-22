package com.sonns.business.repo;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.PostsProxyDto;
import com.sonns.business.dto.PostsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo {
    void createPost(PostCreateRequest post);
    Page<PostsProxyDto> getPosts(Pageable pageable);
}

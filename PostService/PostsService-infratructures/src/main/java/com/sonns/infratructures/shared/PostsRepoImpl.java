package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.PostsProxyDto;
import com.sonns.business.repo.PostsRepo;
import com.sonns.infratructures.mapper.PostsMapper;
import com.sonns.infratructures.model.Posts;
import com.sonns.infratructures.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostsRepoImpl implements PostsRepo {

    private final PostsRepository postsRepository;
    private final PostsMapper postsMapper;

    @Override
    public PostsDto createPost(PostCreateRequest post) {
        Posts posts = postsRepository.save(postsMapper.toEntity(post));
        return postsMapper.toDto(posts);
    }

    @Override
    public Page<PostsProxyDto> getPosts(Pageable pageable) {
        Page<PostsProxyDto> response = postsRepository.findAllPostsWithRepost(pageable);
        return response;
    }
}

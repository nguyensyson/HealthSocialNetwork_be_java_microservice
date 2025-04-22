package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.PostsProxyDto;
import com.sonns.business.repo.PostsRepo;
import com.sonns.infratructures.mapper.PostsMapper;
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
    public void createPost(PostCreateRequest post) {
        postsRepository.save(postsMapper.toEntity(post));
    }

    @Override
    public Page<PostsProxyDto> getPosts(Pageable pageable) {
        Page<PostsProxyDto> response = postsRepository.findAllPostsWithRepost(pageable);
        return response;
    }
}

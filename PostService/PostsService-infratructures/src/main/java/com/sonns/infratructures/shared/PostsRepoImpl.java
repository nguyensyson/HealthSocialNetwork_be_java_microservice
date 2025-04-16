package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.repo.PostsRepo;
import com.sonns.infratructures.mapper.PostsMapper;
import com.sonns.infratructures.model.Posts;
import com.sonns.infratructures.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
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
}

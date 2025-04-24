package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostMediaDto;
import com.sonns.business.dto.PostsDto;
import com.sonns.business.dto.proxy.PostsProxyDto;
import com.sonns.business.repo.PostsRepo;
import com.sonns.infratructures.mapper.PostMediaMapper;
import com.sonns.infratructures.mapper.PostsMapper;
import com.sonns.infratructures.model.PostMedia;
import com.sonns.infratructures.model.Posts;
import com.sonns.infratructures.repository.PostMediaRepository;
import com.sonns.infratructures.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostsRepoImpl implements PostsRepo {

    private final PostsRepository postsRepository;
    private final PostsMapper postsMapper;
    private final PostMediaRepository postMediaRepository;
    private final PostMediaMapper postMediaMapper;

    @Override
    public PostsDto createPost(PostCreateRequest post) {
        Posts posts = postsRepository.save(postsMapper.toEntity(post));
        return postsMapper.toDto(posts);
    }

    @Override
    public Page<PostsProxyDto> getPosts(Pageable pageable) {
        return postsRepository.findAllPostsWithRepost(pageable);
    }

    @Override
    public PostsDto getPostById(String id) {
        Posts post = postsRepository.findById(id).orElse(null);
        if (post == null) { return null; }
        List<PostMedia> postMedia = postMediaRepository.getPostMediaByPostId(id);
        List<PostMediaDto> postMediaDtos = postMedia.stream()
                .map(postMediaMapper::toDto)
                .collect(Collectors.toList());

        return PostsDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .mediaImages(postMediaDtos)
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    @Override
    public PostsProxyDto getPostDetail(String id) {
        return postsRepository.getPostsDetail(id);
    }
}

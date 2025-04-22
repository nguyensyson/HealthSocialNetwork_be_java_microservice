package com.sonns.business.services.impl;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.business.dto.PostStatsResponse;
import com.sonns.business.dto.PostsProxyDto;
import com.sonns.business.dto.PostsResponse;
import com.sonns.business.repo.PostsRepo;
import com.sonns.business.repo.ReactionCommentService;
import com.sonns.business.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepo postsRepo;
    private final ReactionCommentService reactionCommentService;

    @Override
    public void createPost(PostCreateRequest post) {
        postsRepo.createPost(post);
    }

    @Override
    public Page<PostsResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<PostsProxyDto> postsPage = postsRepo.getPosts(pageable);

        List<PostsResponse> responses = postsPage.stream()
                .map(post -> {
                    PostStatsResponse stats = reactionCommentService.getPostStats(post.getId()).block();
                    return PostsResponse.builder()
                            .id(post.getId())
                            .content(post.getContent())
                            .likes(stats.getLikeCount())
                            .comments(stats.getCommentCount())
                            .repost(post.getRepost())
                            .createdAt(post.getCreatedAt())
                            .updatedAt(post.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(responses, pageable, postsPage.getTotalElements());
    }
}

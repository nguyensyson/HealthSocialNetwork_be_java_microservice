package com.sonns.business.services.impl;

import com.sonns.business.dto.PostStatsResponse;
import com.sonns.business.repo.CommentsRepo;
import com.sonns.business.repo.ReactionsRepo;
import com.sonns.business.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final ReactionsRepo reactionsRepo;
    private final CommentsRepo commentsRepo;

    @Override
    public PostStatsResponse getPostStats(String postId) {
        Integer likeCount = reactionsRepo.countLikesByPost(postId);
        Integer commentCount = commentsRepo.countCommentsByPost(postId);

        return PostStatsResponse.builder()
                .likeCount(likeCount)
                .commentCount(commentCount)
                .build();
    }
}

package com.sonns.business.repo;

import com.sonns.business.dto.PostStatsResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ReactionCommentService {
    Mono<PostStatsResponse> getPostStats(String postId);
}

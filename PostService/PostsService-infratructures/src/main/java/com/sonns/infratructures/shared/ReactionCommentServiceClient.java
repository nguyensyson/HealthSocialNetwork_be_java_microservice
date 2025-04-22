package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostStatsResponse;
import com.sonns.business.repo.ReactionCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ReactionCommentServiceClient implements ReactionCommentService {

    private final WebClient webClient;

    @Override
    public Mono<PostStatsResponse> getPostStats(String postId) {
        return webClient.get()
                .uri("http://localhost:8092/api/v1/stats/{postId}", postId)
                .retrieve()
                .bodyToMono(PostStatsResponse.class);
    }
}

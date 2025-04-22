package com.sonns.business.services;

import com.sonns.business.dto.PostStatsResponse;
import org.springframework.stereotype.Service;

@Service
public interface StatsService {
    PostStatsResponse getPostStats(String postId);
}

package com.sonns.business.services.impl;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.repo.FollowRepo;
import com.sonns.business.services.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepo followRepo;

    @Override
    public Integer countFollow(String userId) {
        return followRepo.countFollow(userId);
    }

    @Override
    public Boolean follow(FollowRequest request) {
        return followRepo.follow(request);
    }
}

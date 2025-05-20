package com.sonns.business.services.impl;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.dto.proxy.UserFollowResponseProxy;
import com.sonns.business.repo.FollowRepo;
import com.sonns.business.services.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepo followRepo;

    @Override
    public Integer countFollow(String userId) {
        return followRepo.countFollow(userId);
    }

    @Override
    public List<UserFollowResponseProxy> getFollower(String userId) {
        return followRepo.getFollower(userId);
    }

    @Override
    public List<UserFollowResponseProxy> getFollowing(String userId) {
        return followRepo.getFollowing(userId);
    }

    @Override
    public Boolean follow(FollowRequest request) {
        return followRepo.follow(request);
    }
}

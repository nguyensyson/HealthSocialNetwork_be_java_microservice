package com.sonns.business.services;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.dto.proxy.UserFollowResponseProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
    Boolean follow(FollowRequest request);
    Integer countFollow(String userId);
    List<UserFollowResponseProxy> getFollower(String userId);
    List<UserFollowResponseProxy> getFollowing(String userId);
}

package com.sonns.business.repo;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.dto.proxy.UserFollowResponseProxy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepo {
    Boolean follow(FollowRequest request);
    Integer countFollow(String userId);
    List<UserFollowResponseProxy> getFollower(String userId);
}

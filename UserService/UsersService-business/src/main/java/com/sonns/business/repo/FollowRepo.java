package com.sonns.business.repo;

import com.sonns.business.dto.FollowRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepo {
    Boolean follow(FollowRequest request);
    Integer countFollow(String userId);
}

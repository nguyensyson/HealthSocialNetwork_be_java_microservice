package com.sonns.business.services;

import com.sonns.business.dto.FollowRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public interface FollowService {
    Boolean follow(FollowRequest request);
    Integer countFollow(String userId);

}

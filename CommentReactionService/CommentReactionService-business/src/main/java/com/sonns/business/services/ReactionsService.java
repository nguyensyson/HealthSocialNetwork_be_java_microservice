package com.sonns.business.services;

import com.sonns.business.dto.ReactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ReactionsService {
    void reactions(ReactionRequest reactions);
}

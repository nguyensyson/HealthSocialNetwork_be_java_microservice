package com.sonns.business.services.impl;

import com.sonns.business.dto.ReactionDto;
import com.sonns.business.dto.ReactionRequest;
import com.sonns.business.repo.ReactionsRepo;
import com.sonns.business.services.ReactionsService;
import org.springframework.stereotype.Service;

@Service
public class ReactionsServiceImpl implements ReactionsService {

    private ReactionsRepo reactionsRepo;
    @Override
    public void reactions(ReactionRequest reactions) {
        ReactionDto reactionDto = null;

        if (reactions.getUserId() != null && reactions.getPostId() != null) {
            reactionDto = reactionsRepo.findByPostIdAndUserId(reactions.getPostId(), reactions.getUserId());
        }
        else if (reactions.getUserId() != null && reactions.getCommentId() != null) {
            reactionDto = reactionsRepo.findByCommentIdAndUserId(reactions.getCommentId(), reactions.getUserId());
        }

        if (reactionDto == null || reactionDto.getId() == null) {
            reactionsRepo.save(reactions);
        } else {
            reactionsRepo.updateActiveReaction(reactionDto.getId());
        }

    }
}

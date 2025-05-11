package com.sonns.infratructures.shared;

import com.sonns.business.dto.ReactionDto;
import com.sonns.business.dto.ReactionRequest;
import com.sonns.business.repo.ReactionsRepo;
import com.sonns.infratructures.mapper.ReactionMapper;
import com.sonns.infratructures.model.DeletedStatus;
import com.sonns.infratructures.model.Reactions;
import com.sonns.infratructures.repository.CommentsResponsitory;
import com.sonns.infratructures.repository.ReactionsRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReactionsRepoImpl implements ReactionsRepo {

    private final ReactionsRespository reactionsRespository;
    private final ReactionMapper reactionMapper;
    private final CommentsResponsitory commentsResponsitory;

    @Override
    public Integer countLikesByPost(String postId) {
        Integer likesCount = reactionsRespository.countByPostId(postId);
        return likesCount;
    }

    @Override
    public ReactionDto findByPostIdAndUserId(String postId, String userId) {
        Reactions reactions = reactionsRespository.getReactionsByPostIdAndUserId(postId, userId);
        return reactionMapper.entityToDto(reactions);
    }

    @Override
    public ReactionDto findByCommentIdAndUserId(String commentId, String userId) {
        Reactions reactions = reactionsRespository.getReactionsByCommentIdAndUserId(commentId, userId);
        return reactionMapper.entityToDto(reactions);
    }

    @Override
    public void save(ReactionRequest request) {
        Reactions reactions = new Reactions();
        reactions.setUserId(request.getUserId());
        reactions.setPostId(request.getPostId());
        reactions.setCommentId(commentsResponsitory.getById(request.getCommentId()));
        reactions.setDeleted(DeletedStatus.ACTIVE);
        reactionsRespository.save(reactions);
    }

    @Override
    public void updateActiveReaction(String reactionId) {
        Reactions reactions = reactionsRespository.getById(reactionId);
        DeletedStatus deletedStatus = reactions.getDeleted() == DeletedStatus.ACTIVE ? DeletedStatus.DELETED : DeletedStatus.ACTIVE;
        reactions.setDeleted(deletedStatus);
        reactionsRespository.save(reactions);
    }
}

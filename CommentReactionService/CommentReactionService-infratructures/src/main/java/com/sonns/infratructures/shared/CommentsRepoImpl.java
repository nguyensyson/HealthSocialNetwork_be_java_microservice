package com.sonns.infratructures.shared;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.business.repo.CommentsRepo;
import com.sonns.infratructures.mapper.CommentMapper;
import com.sonns.infratructures.model.Comments;
import com.sonns.infratructures.model.DeletedStatus;
import com.sonns.infratructures.repository.CommentsResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentsRepoImpl implements CommentsRepo {

    private final CommentsResponsitory commentsResponsitory;
    private final CommentMapper commentMapper;

    @Override
    public Integer countCommentsByPost(String postId) {
        Integer commentCount = commentsResponsitory.countByPostId(postId);
        return commentCount;
    }

    @Override
    public void addComment(AddCommentRequest comment) {
        Comments comments = commentMapper.requestToEntiry(comment);
        comments.setParentId(Optional.ofNullable(comment.getParentId())
                .map(commentsResponsitory::getById)
                .orElse(null));
        commentsResponsitory.save(comments);
    }

    @Override
    public void editComment(String id, AddCommentRequest comment) {
        Comments comments = commentsResponsitory.getById(id);
        comments.setContent(comment.getContent());
        commentsResponsitory.save(comments);
    }

    @Override
    public void deleteComment(String id) {
        Comments comments = commentsResponsitory.getById(id);
        comments.setDeleted(DeletedStatus.DELETED);
        commentsResponsitory.save(comments);
    }
}

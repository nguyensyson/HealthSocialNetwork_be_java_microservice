package com.sonns.infratructures.mapper;

import com.sonns.business.dto.AddCommentRequest;
import com.sonns.infratructures.model.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comments requestToEntiry(AddCommentRequest addCommentRequest);
}

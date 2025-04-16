package com.sonns.infratructures.mapper;

import com.sonns.business.dto.PostCreateRequest;
import com.sonns.infratructures.model.Posts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostsMapper {
    Posts toEntity(PostCreateRequest post);
}

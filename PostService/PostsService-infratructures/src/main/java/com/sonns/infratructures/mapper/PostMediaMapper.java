package com.sonns.infratructures.mapper;

import com.sonns.business.dto.PostMediaDto;
import com.sonns.infratructures.model.PostMedia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMediaMapper {
    PostMedia toEntity(PostMediaDto dto);
}

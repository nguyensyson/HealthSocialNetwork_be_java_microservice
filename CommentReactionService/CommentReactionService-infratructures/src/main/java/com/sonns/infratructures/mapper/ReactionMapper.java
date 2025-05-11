package com.sonns.infratructures.mapper;

import com.sonns.business.dto.ReactionDto;
import com.sonns.infratructures.model.Reactions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReactionMapper {
    ReactionDto entityToDto(Reactions reactions);
    Reactions dtoToEntity(ReactionDto reactions);
}

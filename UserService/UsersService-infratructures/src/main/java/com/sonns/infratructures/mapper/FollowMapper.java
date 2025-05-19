package com.sonns.infratructures.mapper;

import com.sonns.business.dto.FollowRequest;
import com.sonns.infratructures.model.Follows;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FollowMapper {
    Follows toFollows(FollowRequest follows);
    FollowRequest toFollowRequest(Follows follows);
}

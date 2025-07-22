package com.sonns.infratructures.mapper;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.business.dto.UserProfileResponse;
import com.sonns.infratructures.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUsers(CreateUsersRequest user);

    @Mapping(source = "id", target = "userId")
    UserProfileResponse toUserProfileResponse(Users user);
}

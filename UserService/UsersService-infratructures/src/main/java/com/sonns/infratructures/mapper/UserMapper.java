package com.sonns.infratructures.mapper;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.infratructures.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUsers(CreateUsersRequest user);
}

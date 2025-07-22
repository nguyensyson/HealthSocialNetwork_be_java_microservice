package sme.hub.business.mapper;

import org.mapstruct.Mapper;
import sme.hub.business.dto.CreateUserProfileParam;
import sme.hub.business.dto.CreateUsersRequest;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    CreateUserProfileParam toParamUserClient(CreateUsersRequest user);
}

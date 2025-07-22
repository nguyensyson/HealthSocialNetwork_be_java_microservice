package sme.hub.business.repo;

import org.springframework.stereotype.Repository;
import sme.hub.business.dto.CreateUserProfileParam;
import sme.hub.business.dto.UserProfileResponse;

@Repository
public interface UserProfileClientRepo {
    void createUsersProfile(CreateUserProfileParam request);
    UserProfileResponse getUserProfile(String userId);
}

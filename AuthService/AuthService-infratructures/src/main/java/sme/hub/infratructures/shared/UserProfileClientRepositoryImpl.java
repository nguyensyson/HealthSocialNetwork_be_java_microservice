package sme.hub.infratructures.shared;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sme.hub.business.dto.CreateUserProfileParam;
import sme.hub.business.dto.UserProfileResponse;
import sme.hub.business.repo.UserProfileClientRepo;
import sme.hub.infratructures.repo.UserClient;

@Repository
@RequiredArgsConstructor
public class UserProfileClientRepositoryImpl implements UserProfileClientRepo {
    private final UserClient userClient;

    @Override
    public void createUsersProfile(CreateUserProfileParam request) {
        userClient.createUserProfile(request);
    }

    @Override
    public UserProfileResponse getUserProfile(String userId) {
        return userClient.getUserProfile(userId);
    }
}

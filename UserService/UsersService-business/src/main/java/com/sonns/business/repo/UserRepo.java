package com.sonns.business.repo;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.business.dto.UserProfileResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    void createUser(CreateUsersRequest user);
    UserProfileResponse getUserByKeycloakId(String keycloakId);
}

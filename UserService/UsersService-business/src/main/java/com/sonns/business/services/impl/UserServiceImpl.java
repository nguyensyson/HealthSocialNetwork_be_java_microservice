package com.sonns.business.services.impl;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.business.dto.UserProfileResponse;
import com.sonns.business.repo.UserRepo;
import com.sonns.business.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public Boolean createUser(CreateUsersRequest user) {
        userRepo.createUser(user);
        return true;
    }

    @Override
    public UserProfileResponse getUserByKeycloakId(String keycloakId) {
        return userRepo.getUserByKeycloakId(keycloakId);
    }
}

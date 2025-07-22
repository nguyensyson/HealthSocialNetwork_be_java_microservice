package sme.hub.business.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sme.hub.business.config.JwtUtils;
import sme.hub.business.dto.*;
import sme.hub.business.mapper.UsersMapper;
import sme.hub.business.repo.IdentityClientRepo;
import sme.hub.business.repo.UserProfileClientRepo;
import sme.hub.business.services.UsersService;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final IdentityClientRepo identityClientRepo;
    private final UserProfileClientRepo userProfileClientRepo;
    private final UsersMapper usersMapper;

    @Override
    public void register(CreateUsersRequest request) {
        String userId = identityClientRepo.createUsersKeycloak(request);
        CreateUserProfileParam createUserProfileParam = usersMapper.toParamUserClient(request);
        createUserProfileParam.setKeycloakId(userId);

        userProfileClientRepo.createUsersProfile(createUserProfileParam);
    }

    @Override
    public void logout(String refreshToken) {
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        TokenResponse tokenResponse = identityClientRepo.exchangeTokenByPassWord(request);
        String accessToken = tokenResponse.getAccessToken();
        String userKeycloakId = JwtUtils.getSubjectFromToken(accessToken);
        UserProfileResponse userProfileResponse = userProfileClientRepo.getUserProfile(userKeycloakId);
        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(tokenResponse.getRefreshToken())
                .email(userProfileResponse.getEmail())
                .firstName(userProfileResponse.getFirstName())
                .userId(userProfileResponse.getUserId())
                .lastName(userProfileResponse.getLastName())
                .phone(userProfileResponse.getPhone())
                .build();
    }
}

package sme.hub.business.services;

import sme.hub.business.dto.CreateUsersRequest;
import sme.hub.business.dto.LoginRequest;
import sme.hub.business.dto.LoginResponse;

public interface UsersService {
    void register(CreateUsersRequest request);
    void logout(String refreshToken);
    LoginResponse login(LoginRequest request);
}

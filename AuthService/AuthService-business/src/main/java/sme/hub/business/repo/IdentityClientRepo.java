package sme.hub.business.repo;

import sme.hub.business.dto.CreateUsersRequest;
import sme.hub.business.dto.LoginRequest;
import sme.hub.business.dto.TokenResponse;

public interface IdentityClientRepo {

    String createUsersKeycloak(CreateUsersRequest request);
    TokenResponse exchangeTokenByPassWord(LoginRequest request);
}

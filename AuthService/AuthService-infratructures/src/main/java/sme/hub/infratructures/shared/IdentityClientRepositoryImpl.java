package sme.hub.infratructures.shared;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import sme.hub.business.dto.*;
import sme.hub.business.repo.IdentityClientRepo;
import sme.hub.common.exception.ErrorNormalizer;
import sme.hub.infratructures.repo.IdentityClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IdentityClientRepositoryImpl implements IdentityClientRepo {
    private final IdentityClient identityClient;
    private final ErrorNormalizer errorNormalizer;

    @Value("${keycloak.client-id}")
    @NonFinal
    String clientId;

    @Value("${keycloak.client-secret}")
    @NonFinal
    String clientSecret;

    @Override
    public String createUsersKeycloak(CreateUsersRequest request) {
        try {
            // Create account in KeyCloak
            // Exchange client Token
            var token = identityClient.exchangeToken(TokenExchangeParam.builder()
                    .grant_type("client_credentials")
                    .client_id(clientId)
                    .client_secret(clientSecret)
                    .scope("openid")
                    .build());

            log.info("TokenInfo {}", token);
            // Create user with client Token and given info

            // Get userId of keyCloak account
            var creationResponse = identityClient.createUser(
                    "Bearer " + token.getAccessToken(),
                    UserCreationParam.builder()
                            .username(request.getUsername())
                            .firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .email(request.getEmail())
                            .enabled(true)
                            .emailVerified(false)
                            .credentials(List.of(Credential.builder()
                                    .type("password")
                                    .temporary(false)
                                    .value(request.getPassword())
                                    .build()))
                            .build());

            String userId = extractUserId(creationResponse);
            log.info("UserId {}", userId);
            return userId;
        } catch (FeignException exception) {
            throw errorNormalizer.handleKeyCloakException(exception);
        }
    }

    @Override
    public TokenResponse exchangeTokenByPassWord(LoginRequest request) {
        var token = identityClient.exchangeToken(TokenExchangeParam.builder()
                        .grant_type("password")
                        .client_id(clientId)
                        .client_secret(clientSecret)
                        .scope("openid")
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .build());

        return TokenResponse.builder()
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .build();
    }

    private String extractUserId(ResponseEntity<?> response) {
        List<String> locations = response.getHeaders().get("Location");
        if (locations == null || locations.isEmpty()) {
            throw new IllegalStateException("Missing Location header");
        }
        String location = locations.get(0);
        String[] splitedStr = location.split("/");
        return splitedStr[splitedStr.length - 1];
    }

}

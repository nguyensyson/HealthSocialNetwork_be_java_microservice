package sme.hub.infratructures.repo;

import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import sme.hub.business.dto.TokenExchangeParam;
import sme.hub.business.dto.TokenExchangeResponse;
import sme.hub.business.dto.UserCreationParam;

@FeignClient(name = "identity-client", url = "${keycloak.server-url}")
public interface IdentityClient {
    @PostMapping(
            value = "/realms/social_network/protocol/openid-connect/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenExchangeResponse exchangeToken(@QueryMap TokenExchangeParam param);

    @PostMapping(value = "/admin/realms/social_network/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createUser(@RequestHeader("authorization") String token, @RequestBody UserCreationParam param);
}

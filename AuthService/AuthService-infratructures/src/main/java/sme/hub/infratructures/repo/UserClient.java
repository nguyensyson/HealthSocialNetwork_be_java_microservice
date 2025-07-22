package sme.hub.infratructures.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sme.hub.business.dto.CreateUserProfileParam;
import sme.hub.business.dto.UserProfileResponse;

@FeignClient(name = "user-client", url = "${user-client.url}")
public interface UserClient {
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createUserProfile(@RequestBody CreateUserProfileParam param);

    @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse getUserProfile(@RequestParam("userId") String userId);
}

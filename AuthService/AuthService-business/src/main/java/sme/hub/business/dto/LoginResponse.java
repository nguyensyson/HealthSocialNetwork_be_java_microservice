package sme.hub.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
}

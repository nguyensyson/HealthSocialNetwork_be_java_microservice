package sme.hub.business.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserProfileParam {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phone;
    private String keycloakId;
}

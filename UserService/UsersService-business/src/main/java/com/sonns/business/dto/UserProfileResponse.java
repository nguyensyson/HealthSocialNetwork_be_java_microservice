package com.sonns.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProfileResponse {
    private String userId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
}

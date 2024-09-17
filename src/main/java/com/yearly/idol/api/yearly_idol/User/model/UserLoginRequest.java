package com.yearly.idol.api.yearly_idol.User.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yearly.idol.api.yearly_idol.Common.annotation.Password;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserLoginRequest {
    @Email
    private String email;

    @Password
    private String password;
}

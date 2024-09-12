package com.yearly.idol.api.yearly_idol.User.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yearly.idol.api.yearly_idol.Common.annotation.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserLocalLoginRequestDto {
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max=30)
    @Password
    private String password;
}

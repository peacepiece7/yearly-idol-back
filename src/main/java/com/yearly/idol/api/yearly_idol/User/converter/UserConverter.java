package com.yearly.idol.api.yearly_idol.User.converter;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yearly.idol.api.yearly_idol.User.model.UserEntity;
import com.yearly.idol.api.yearly_idol.User.model.request.UserLocalLoginRequestDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserConverter {

    public UserEntity toEntityByUserLocalLoginDto(
            UserLocalLoginRequestDto userLocalLoginDto
    ) {
        return  UserEntity.builder()
                .email(userLocalLoginDto.getEmail())
                .password(userLocalLoginDto.getPassword())
                .userName("USER" + UUID.randomUUID().toString())
                .profileImage("no_profile_image.png")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public UserLocalLoginRequestDto toUserLocalLoginDto(
            UserEntity userEntity
    ) {
        return UserLocalLoginRequestDto.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}

package com.yearly.idol.api.yearly_idol.User.service;


import com.yearly.idol.api.yearly_idol.User.db.UserEntity;
import com.yearly.idol.api.yearly_idol.User.model.UserDetailDto;
import com.yearly.idol.api.yearly_idol.User.model.UserLoginRequest;
import com.yearly.idol.api.yearly_idol.User.model.UserSignUpRequest;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class UserConverter {
    public UserEntity toEntity(
            UserSignUpRequest userSignUpRequest
    ) {
      return UserEntity.builder()
              .email(userSignUpRequest.getEmail())
              .password(userSignUpRequest.getPassword())
              .userName(userSignUpRequest.getUserName())
              .profileImage("no_profile_image.png")
              .createdAt(LocalDateTime.now())
              .updatedAt(LocalDateTime.now())
              .build();
    }

    public UserSignUpRequest toDto(
            UserEntity userEntity
    ) {
        return UserSignUpRequest.builder()
                .email(userEntity.getEmail())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .build();
    }

    public UserDetailDto toUserDto(
            UserEntity userEntity
    ) {
        return UserDetailDto.builder()
                .email(userEntity.getEmail())
                .userName(userEntity.getUserName())
                .profileImage(userEntity.getProfileImage())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }

    public UserDetailDto toUserDtoByClaim(Claims claims) {
        String email = (String) claims.get("email");
        String userName = (String) claims.get("user_name");
        String profileImage = (String) claims.get("profile_image");

        String createdAtStr = (String) claims.get("created_at");
        String updatedAtStr = (String) claims.get("updated_at");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime createdAt = LocalDateTime.parse(createdAtStr, formatter);
        LocalDateTime updatedAt = LocalDateTime.parse(updatedAtStr, formatter);

        return UserDetailDto.builder()
                .email(email)
                .userName(userName)
                .profileImage(profileImage)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}

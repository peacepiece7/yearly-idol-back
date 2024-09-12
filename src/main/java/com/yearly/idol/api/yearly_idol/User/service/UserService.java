package com.yearly.idol.api.yearly_idol.User.service;

import com.yearly.idol.api.yearly_idol.User.controller.UserController;
import com.yearly.idol.api.yearly_idol.User.converter.UserConverter;
import com.yearly.idol.api.yearly_idol.User.db.UserRepository;
import com.yearly.idol.api.yearly_idol.User.model.UserEntity;
import com.yearly.idol.api.yearly_idol.User.model.request.UserLocalLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserLocalLoginRequestDto login(
            UserLocalLoginRequestDto userLocalLoginRequestDto
    ) {
        var userEntity = userConverter.toEntityByUserLocalLoginDto(userLocalLoginRequestDto);

        userRepository.save(userEntity);

        return userConverter.toUserLocalLoginDto(userEntity);
    }
}

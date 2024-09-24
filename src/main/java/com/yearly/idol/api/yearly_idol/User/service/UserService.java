package com.yearly.idol.api.yearly_idol.User.service;

import com.yearly.idol.api.yearly_idol.SchedulerContent.service.SchedulerContentService;
import com.yearly.idol.api.yearly_idol.User.db.UserEntity;
import com.yearly.idol.api.yearly_idol.User.db.UserRepository;
import com.yearly.idol.api.yearly_idol.User.model.UserDetailDto;
import com.yearly.idol.api.yearly_idol.User.model.UserLoginRequest;
import com.yearly.idol.api.yearly_idol.User.model.UserSignUpRequest;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final SchedulerContentService schedulerService;
    private final JwtService jwtService;

    @Transactional
    public UserSignUpRequest signUp(
            UserSignUpRequest userSignUpRequest
    ) {
       validateExistAccountByEmail(userSignUpRequest);

       var userEntity = userConverter.toEntity(userSignUpRequest);
       userRepository.save(userEntity);
       schedulerService.createScheduler(userEntity.getId());
       return userConverter.toDto(userEntity);
    }
    
    // @TODO String -> Token class 만들어서 getAccessToken, getRefreshToken 추가하기
    public UserDetailDto login(
            UserLoginRequest userLoginRequest,
            HttpServletResponse httpServletResponse
    ) {
        // @TODO 로그인 인증 절차 없음
        // @TODO Enum 으로 에러 메시지 관리
        var userEntity = validateExistAccountByEmailAndPassword(userLoginRequest);

        // @TODO encode, decode 로직 추가 필요
        if(!Objects.equals(userEntity.getPassword(), userLoginRequest.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        var jwt =  jwtService.create(userEntity);
        log.info("\nISSUED token: {}", jwt);
        jwtService.insertJwtToCookie(jwt, httpServletResponse);

        return userConverter.toUserDto(userEntity);
    };

    public UserDetailDto getMe(
            String token
    ) {
        try{
            var claims = jwtService.parseToken(token);
            return userConverter.toUserDtoByClaim(claims);
            // @TODO 이거 예외 처리 어짜지?
        } catch(Exception e) {
            if(e instanceof SignatureException){
                throw new RuntimeException("JWT Token Not Valid Exception");
            }
            else if(e instanceof ExpiredJwtException){
                throw new RuntimeException("JWT Token Expired Exception");
            }
            else{
                throw new RuntimeException("JWT Token Validation Exception");
            }
        }
    }




    public UserEntity validateExistAccountByEmailAndPassword(UserLoginRequest userLoginRequest) {
        var userEntity = userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        if(userEntity.isEmpty()) {
            throw new IllegalArgumentException("해당 아아디는 존재하지 않습니다.");
        }
        return userEntity.get();
    }

    public void validateExistAccountByEmail(UserSignUpRequest userSignUpRequest) {
        var user = userRepository.findByEmail(userSignUpRequest.getEmail());
        if(user.isPresent()) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }
    }
}
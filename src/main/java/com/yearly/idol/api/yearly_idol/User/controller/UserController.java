package com.yearly.idol.api.yearly_idol.User.controller;

import com.yearly.idol.api.yearly_idol.Common.model.Api;
import com.yearly.idol.api.yearly_idol.User.model.UserDetailDto;
import com.yearly.idol.api.yearly_idol.User.model.UserLoginRequest;
import com.yearly.idol.api.yearly_idol.User.model.UserSignUpRequest;
import com.yearly.idol.api.yearly_idol.User.service.JwtService;
import com.yearly.idol.api.yearly_idol.User.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/me")
    public ResponseEntity<Api<UserDetailDto>> me(
            @CookieValue(name = "authorization")
            String token
    ) {
        var response = userService.getMe(token);
        var body = Api.<UserDetailDto>builder()
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(body);
    };

    @PostMapping("/signUp")
    public ResponseEntity<Api<UserSignUpRequest>> signUp(
            @Valid
            @RequestBody
            UserSignUpRequest userSignUpRequest
    ) {
        var response = userService.signUp(userSignUpRequest);

        // @TODO SignUpRequest 그대로 돌려주는게 맞을까? 이름이 SignUpDto 같은게 되어야 할 것 같은데 흠..
        var body = Api.<UserSignUpRequest>builder()
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/login")
    public ResponseEntity<Api<UserDetailDto>>login(
            @Valid
            @RequestBody
            UserLoginRequest userLoginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var response = userService.login(userLoginRequest, httpServletResponse);
        var body = Api.<UserDetailDto>builder()
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(
            HttpServletResponse httpServletResponse
    ) {
        // @TODO JWT 로 로그아웃 구현은 복잡해지네..
        // https://engineerinsight.tistory.com/232
        var cookie = new Cookie("authorization", "");
        httpServletResponse.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
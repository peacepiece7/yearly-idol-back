package com.yearly.idol.api.yearly_idol.User.controller;


import com.yearly.idol.api.yearly_idol.Common.model.Api;
import com.yearly.idol.api.yearly_idol.User.model.request.UserLocalLoginRequestDto;
import com.yearly.idol.api.yearly_idol.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Api<Object>> login(
            @Valid
            @RequestBody
            UserLocalLoginRequestDto userLocalLoginDto
    ) {
        var response = userService.login(userLocalLoginDto);

        var body = Api.builder()
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/logout")
    public void logout() {}
}

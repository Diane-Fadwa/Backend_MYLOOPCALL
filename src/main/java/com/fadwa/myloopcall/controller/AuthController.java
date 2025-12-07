package com.fadwa.myloopcall.controller;


import com.fadwa.myloopcall.dto.UserDto;
import com.fadwa.myloopcall.dto.UserLoginRequestDto;
import com.fadwa.myloopcall.service.AuthenticationService;
import com.fadwa.myloopcall.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@RestController
@RequestMapping("${app.api.prefix}/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid UserLoginRequestDto loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(loginRequest.email(), loginRequest.password());
        String tokenValue = authenticationService.generateToken(userDetails);
        UserDto user = userService.getUserByEmail(userDetails.getUsername());
        UserDto response = objectMapper.updateValue(user,
                Map.of("token", tokenValue)
        );

        return ResponseEntity.ok(response);
    }


}

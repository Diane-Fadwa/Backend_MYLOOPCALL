package com.fadwa.myloopcall.controller;


import com.fadwa.myloopcall.dto.UserDTO;
import com.fadwa.myloopcall.dto.UserDTO;
import com.fadwa.myloopcall.dto.UserLoginRequestDto;
import com.fadwa.myloopcall.service.AuthenticationService;
import com.fadwa.myloopcall.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("${app.api.prefix}/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid UserLoginRequestDto loginRequest) {
        log.debug(loginRequest.toString());
        UserDetails userDetails = authenticationService.authenticate(loginRequest.email(), loginRequest.password());
        String tokenValue = authenticationService.generateToken(userDetails);
        UserDTO user = userService.getUserByEmail(userDetails.getUsername());
        user.setToken(tokenValue);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/admin")
    public ResponseEntity<?> test() {
            userService.createUser();
        return ResponseEntity.ok(true);
    }




}

package com.fadwa.myloopcall.dto;

import com.fadwa.myloopcall.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class UserDTO{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private RoleEnum role;
    private String profileImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String token;
}

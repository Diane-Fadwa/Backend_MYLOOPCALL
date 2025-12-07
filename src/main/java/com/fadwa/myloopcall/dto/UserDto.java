package com.fadwa.myloopcall.dto;

import com.fadwa.myloopcall.enums.RoleEnum;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String email,
        String firstName,
        String lastName,
        RoleEnum role,
        String profileImage,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String token
) {
}

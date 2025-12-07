package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.UserDto;

public interface UserService {
    UserDto getUserByEmail(String value);
}

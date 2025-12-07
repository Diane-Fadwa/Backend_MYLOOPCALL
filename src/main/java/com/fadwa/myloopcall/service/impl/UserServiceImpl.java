package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.UserDto;
import com.fadwa.myloopcall.entity.UserEntity;
import com.fadwa.myloopcall.exceptions.UserNotFoundException;
import com.fadwa.myloopcall.repository.UserRepository;
import com.fadwa.myloopcall.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ObjectMapper objectMapper;


    @Override
    public UserDto getUserByEmail(String value) {
        UserEntity user = repository.findByUserByUsernameOrEmail(value).orElseThrow(UserNotFoundException::new);
        return objectMapper.convertValue(user, UserDto.class);
    }

}

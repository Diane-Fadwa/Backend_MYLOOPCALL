package com.fadwa.myloopcall.security.config.userDetails.service;

import com.fadwa.myloopcall.entity.UserEntity;
import com.fadwa.myloopcall.exceptions.EmailNotFoundException;
import com.fadwa.myloopcall.repository.UserRepository;
import com.fadwa.myloopcall.security.config.userDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws EmailNotFoundException {
       UserEntity user = repository.findByEmail(username).orElseThrow(EmailNotFoundException::new);
        return new CustomUserDetails(user);
    }

}

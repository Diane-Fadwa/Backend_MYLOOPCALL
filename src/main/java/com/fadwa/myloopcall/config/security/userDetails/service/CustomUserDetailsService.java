package com.fadwa.myloopcall.config.security.userDetails.service;

import com.fadwa.myloopcall.config.security.userDetails.CustomUserDetails;
import com.fadwa.myloopcall.entity.UserEntity;
import com.fadwa.myloopcall.exceptions.EmailNotFoundException;
import com.fadwa.myloopcall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws EmailNotFoundException {
        UserEntity user = repository.findByUserByUsernameOrEmail(username).orElseThrow(EmailNotFoundException::new);
//        if (user.getDeletedAt() != null){
//            throw  new AccountBannedException();
//        }
        return new CustomUserDetails(user);
    }

}

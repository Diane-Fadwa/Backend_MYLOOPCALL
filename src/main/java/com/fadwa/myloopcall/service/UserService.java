package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    Page<UserDTO> getAllUsers(Pageable pageable);

    void deleteUser(Long id);

//    UserDTO getUserByUsername(String username);

    UserDTO getUserByEmail(String email);

//    List<UserDTO> getActiveUsers();

//    List<UserDTO> getUsersByRole(Long roleId);

//    List<UserDTO> searchUsersByUsername(String username);

//    UserDTO changePassword(Long id, String oldPassword, String newPassword);
//
//    void updateLastLogin(Long id);
}
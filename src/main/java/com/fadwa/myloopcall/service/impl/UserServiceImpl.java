package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.UserDTO;
import com.fadwa.myloopcall.entity.RoleEntity;
import com.fadwa.myloopcall.entity.UserEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.UserMapper;
import com.fadwa.myloopcall.repository.RoleRepository;
import com.fadwa.myloopcall.repository.UserRepository;
import com.fadwa.myloopcall.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("Creating new user: {}", userDTO.getEmail());

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Un utilisateur avec ce nom d'utilisateur existe déjà");
        }

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà");
        }

//        RoleEntity role = roleRepository.findById(userDTO.getRoleId())
//                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + userDTO.getRoleId()));
//
//        UserEntity user = userMapper.toEntity(userDTO);
//        user.setRole(role);
//
//        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
//            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        }
//
//        UserEntity savedUser = userRepository.save(user);
//
//        log.info("User created successfully with id: {}", savedUser.getId());
//        return userMapper.toDTO(savedUser);
//
        return null ;
      }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        log.info("Updating user with id: {}", id);

//        UserEntity existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
//
//        if (userDTO.getRoleId() != null) {
//            RoleEntity role = roleRepository.findById(userDTO.getRoleId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + userDTO.getRoleId()));
//            existingUser.setRole(role);
//        }

//        userMapper.updateEntityFromDTO(userDTO, existingUser);
//
//        UserEntity updatedUser = userRepository.save(existingUser);
//
//        log.info("User updated successfully with id: {}", id);
//        return userMapper.toDTO(updatedUser);

        return null ;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Long id) {
        log.info("Fetching user with id: {}", id);

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        log.info("Fetching all users");
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> usersdto = users.stream().map(userEntity -> userMapper.toDto(userEntity)).toList();
        return usersdto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        log.info("Fetching users with pagination");

        Page<UserEntity> users = userRepository.findAll(pageable);

        List<UserDTO> usersDto = users
                .stream()
                .map(userMapper::toDto)
                .toList();

        return new PageImpl<>(usersDto, pageable, users.getTotalElements());
    }


    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
        log.info("User deleted successfully with id: {}", id);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public UserDTO getUserByUsername(String username) {
//        log.info("Fetching user by username: {}", username);
//
//        UserEntity user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
//
//        return userMapper.toDto(user);
    //}

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserByEmail(String email) {
        log.info("Fetching user by email: {}", email);

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        return userMapper.toDto(user);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<UserDTO> getActiveUsers() {
//        log.info("Fetching active users");
//        List<UserEntity> users = userRepository.findByActif(true);
//        List<UserDTO> usersdto = users.stream().map(userEntity -> userMapper.toDto(userEntity)).toList();
//        return usersdto;
//    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<UserDTO> getUsersByRole(Long roleId) {
//        log.info("Fetching users by role id: {}", roleId);
//        List<UserEntity> users = userRepository.findByRoleId(roleId);
//        return userMapper.toDTOList(users);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<UserDTO> searchUsersByUsername(String username) {
//        log.info("Searching users by username: {}", username);
//        List<UserEntity> users = userRepository.findByUsernameContainingIgnoreCase(username);
//        return userMapper.toDTOList(users);
//    }

//    @Override
//    public UserDTO changePassword(Long id, String oldPassword, String newPassword) {
//        log.info("Changing password for user with id: {}", id);
//
//        UserEntity user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
//
//        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//            throw new IllegalArgumentException("Ancien mot de passe incorrect");
//        }
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        UserEntity updatedUser = userRepository.save(user);
//
//        log.info("Password changed successfully for user with id: {}", id);
//        return userMapper.toDTO(updatedUser);
//    }
//
//    @Override
//    public void updateLastLogin(Long id) {
//        log.info("Updating last login for user with id: {}", id);
//
//        UserEntity user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
//
//        user.setLastLogin(LocalDateTime.now());
//        userRepository.save(user);
//    }
}
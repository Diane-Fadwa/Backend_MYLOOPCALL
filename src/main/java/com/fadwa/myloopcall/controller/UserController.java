package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.UserDTO;
import com.fadwa.myloopcall.security.AdminOnly;
import com.fadwa.myloopcall.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@AdminOnly
public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping
//    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
//        log.info("REST request to create user: {}", userDTO.getEmail());
//        UserDTO createdUser = userService.createUser(userDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> updateUser(
//            @PathVariable Long id,
//            @Valid @RequestBody UserDTO userDTO) {
//        log.info("REST request to update user with id: {}", id);
//        UserDTO updatedUser = userService.updateUser(id, userDTO);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
//        log.info("REST request to get user with id: {}", id);
//        UserDTO user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserDTO>> getAllUsers() {
//        log.info("REST request to get all users");
//        List<UserDTO> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/paginated")
//    public ResponseEntity<Page<UserDTO>> getAllUsersPaginated(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "50") int size,
//            @RequestParam(defaultValue = "username") String sortBy,
//            @RequestParam(defaultValue = "ASC") String sortDir) {
//
//        Sort sort = sortDir.equalsIgnoreCase("ASC")
//                ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();
//
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<UserDTO> users = userService.getAllUsers(pageable);
//
//        return ResponseEntity.ok(users);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        log.info("REST request to delete user with id: {}", id);
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/username/{username}")
//    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
//        log.info("REST request to get user by username: {}", username);
//        UserDTO user = userService.getUserByEmail(username);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/email/{email}")
//    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
//        log.info("REST request to get user by email: {}", email);
//        UserDTO user = userService.getUserByEmail(email);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/active")
//    public ResponseEntity<List<UserDTO>> getActiveUsers() {
//        log.info("REST request to get active users");
//        List<UserDTO> users = userService.getActiveUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/role/{roleId}")
//    public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable Long roleId) {
//        log.info("REST request to get users by role id: {}", roleId);
//        List<UserDTO> users = userService.getUsersByRole(roleId);
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<UserDTO>> searchUsers(@RequestParam String username) {
//        log.info("REST request to search users by username: {}", username);
//        List<UserDTO> users = userService.searchUsersByUsername(username);
//        return ResponseEntity.ok(users);
//    }
//
//    @PostMapping("/{id}/change-password")
//    public ResponseEntity<UserDTO> changePassword(
//            @PathVariable Long id,
//            @RequestBody Map<String, String> passwordData) {
//        log.info("REST request to change password for user with id: {}", id);
//
//        String oldPassword = passwordData.get("oldPassword");
//        String newPassword = passwordData.get("newPassword");
//
//        UserDTO user = userService.changePassword(id, oldPassword, newPassword);
//        return ResponseEntity.ok(user);
//    }
//
//    @PostMapping("/{id}/update-last-login")
//    public ResponseEntity<Void> updateLastLogin(@PathVariable Long id) {
//        log.info("REST request to update last login for user with id: {}", id);
//        userService.updateLastLogin(id);
//        return ResponseEntity.ok().build();
//    }
}
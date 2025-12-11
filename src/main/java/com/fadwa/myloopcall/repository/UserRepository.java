package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

//    List<UserEntity> findByActif(Boolean actif);

    // List<UserEntity> findByRoleId(Long roleId);

//    List<UserEntity> findByUsernameContainingIgnoreCase(String username);
}
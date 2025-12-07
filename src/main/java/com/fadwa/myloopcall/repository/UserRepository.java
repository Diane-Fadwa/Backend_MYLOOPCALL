package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = :value")
    Optional<UserEntity> findByUserByUsernameOrEmail(@Param("value") String value);
}

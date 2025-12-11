package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByNom(String nom);

    boolean existsByNom(String nom);
}
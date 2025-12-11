package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntity, Long> {

    Optional<AgentEntity> findByNom(String nom);

    List<AgentEntity> findByActif(Boolean actif);

    boolean existsByNom(String nom);

    List<AgentEntity> findByNomContainingIgnoreCase(String nom);
}
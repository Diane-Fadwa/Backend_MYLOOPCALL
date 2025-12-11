package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.InstallateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstallateurRepository extends JpaRepository<InstallateurEntity, Long> {

    Optional<InstallateurEntity> findByNom(String nom);

    List<InstallateurEntity> findByActif(Boolean actif);

    boolean existsByNom(String nom);

    List<InstallateurEntity> findByNomContainingIgnoreCase(String nom);

    List<InstallateurEntity> findByVille(String ville);

    Optional<InstallateurEntity> findBySiret(String siret);
}
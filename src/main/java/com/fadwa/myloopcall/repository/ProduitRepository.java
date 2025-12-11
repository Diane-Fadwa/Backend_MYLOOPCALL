package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {

    Optional<ProduitEntity> findByNom(String nom);

    Optional<ProduitEntity> findByCode(String code);

    List<ProduitEntity> findByActif(Boolean actif);

    boolean existsByNom(String nom);

    boolean existsByCode(String code);

    List<ProduitEntity> findByNomContainingIgnoreCase(String nom);
}
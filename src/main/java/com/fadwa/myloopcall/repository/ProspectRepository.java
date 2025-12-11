package com.fadwa.myloopcall.repository;

import com.fadwa.myloopcall.entity.ProspectEntity;
import com.fadwa.myloopcall.enums.StatutEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ProspectRepository extends JpaRepository<ProspectEntity, Long>, JpaSpecificationExecutor<ProspectEntity> {

    // Search by name, prenom, or phone number
    @Query("SELECT p FROM Prospect p WHERE " +
            "LOWER(p.nom) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.prenom) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "p.numeroMobile LIKE CONCAT('%', :searchTerm, '%')")
    List<ProspectEntity> searchProspects(@Param("searchTerm") String searchTerm);

    // Filter by agent
    List<ProspectEntity> findByAgent(String agent);

    // Filter by confirmateur
    List<ProspectEntity> findByConfirmateur(String confirmateur);

    // Filter by statut
    List<ProspectEntity> findByStatut(StatutEnum statut);

    // Filter by produit
    List<ProspectEntity> findByProduit(String produit);

    // Combined filters
    @Query("SELECT p FROM Prospect p WHERE " +
            "(:agent IS NULL OR p.agent = :agent) AND " +
            "(:confirmateur IS NULL OR p.confirmateur = :confirmateur) AND " +
            "(:statut IS NULL OR p.statut = :statut) AND " +
            "(:produit IS NULL OR p.produit = :produit) AND " +
            "(:searchTerm IS NULL OR " +
            "LOWER(p.nom) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.prenom) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "p.numeroMobile LIKE CONCAT('%', :searchTerm, '%'))")
    List<ProspectEntity> findByFilters(
            @Param("agent") String agent,
            @Param("confirmateur") String confirmateur,
            @Param("statut") StatutEnum statut,
            @Param("produit") String produit,
            @Param("searchTerm") String searchTerm
    );

    Page<ProspectEntity> findByDeletedTrue(Pageable pageable);

}
package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.ProduitDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProduitService {

    ProduitDTO createProduit(ProduitDTO produitDTO);

    ProduitDTO updateProduit(Long id, ProduitDTO produitDTO);

    ProduitDTO getProduitById(Long id);

    List<ProduitDTO> getAllProduits();

    Page<ProduitDTO> getAllProduits(Pageable pageable);

    void deleteProduit(Long id);

    List<ProduitDTO> getActiveProduits();

    List<ProduitDTO> searchProduitsByNom(String nom);

    ProduitDTO getProduitByNom(String nom);

    ProduitDTO getProduitByCode(String code);
}
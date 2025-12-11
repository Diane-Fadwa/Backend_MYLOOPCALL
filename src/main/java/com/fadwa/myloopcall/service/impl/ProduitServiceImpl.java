package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.ProduitDTO;
import com.fadwa.myloopcall.entity.ProduitEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.ProduitMapper;
import com.fadwa.myloopcall.repository.ProduitRepository;
import com.fadwa.myloopcall.service.ProduitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @Override
    public ProduitDTO createProduit(ProduitDTO produitDTO) {
        log.info("Creating new produit: {}", produitDTO.getNom());

        if (produitRepository.existsByNom(produitDTO.getNom())) {
            throw new IllegalArgumentException("Un produit avec ce nom existe déjà");
        }

        if (produitDTO.getCode() != null && produitRepository.existsByCode(produitDTO.getCode())) {
            throw new IllegalArgumentException("Un produit avec ce code existe déjà");
        }

        ProduitEntity produit = produitMapper.toEntity(produitDTO);
        ProduitEntity savedProduit = produitRepository.save(produit);

        log.info("Produit created successfully with id: {}", savedProduit.getId());
        return produitMapper.toDTO(savedProduit);
    }

    @Override
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {
        log.info("Updating produit with id: {}", id);

        ProduitEntity existingProduit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with id: " + id));

        produitMapper.updateEntityFromDTO(produitDTO, existingProduit);
        ProduitEntity updatedProduit = produitRepository.save(existingProduit);

        log.info("Produit updated successfully with id: {}", id);
        return produitMapper.toDTO(updatedProduit);
    }

    @Override
    @Transactional(readOnly = true)
    public ProduitDTO getProduitById(Long id) {
        log.info("Fetching produit with id: {}", id);

        ProduitEntity produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with id: " + id));

        return produitMapper.toDTO(produit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitDTO> getAllProduits() {
        log.info("Fetching all produits");
        List<ProduitEntity> produits = produitRepository.findAll();
        return produitMapper.toDTOList(produits);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProduitDTO> getAllProduits(Pageable pageable) {
        log.info("Fetching produits with pagination");
        Page<ProduitEntity> produits = produitRepository.findAll(pageable);
        return produits.map(produitMapper::toDTO);
    }

    @Override
    public void deleteProduit(Long id) {
        log.info("Deleting produit with id: {}", id);

        if (!produitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produit not found with id: " + id);
        }

        produitRepository.deleteById(id);
        log.info("Produit deleted successfully with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitDTO> getActiveProduits() {
        log.info("Fetching active produits");
        List<ProduitEntity> produits = produitRepository.findByActif(true);
        return produitMapper.toDTOList(produits);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitDTO> searchProduitsByNom(String nom) {
        log.info("Searching produits by nom: {}", nom);
        List<ProduitEntity> produits = produitRepository.findByNomContainingIgnoreCase(nom);
        return produitMapper.toDTOList(produits);
    }

    @Override
    @Transactional(readOnly = true)
    public ProduitDTO getProduitByNom(String nom) {
        log.info("Fetching produit by nom: {}", nom);

        ProduitEntity produit = produitRepository.findByNom(nom)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with nom: " + nom));

        return produitMapper.toDTO(produit);
    }

    @Override
    @Transactional(readOnly = true)
    public ProduitDTO getProduitByCode(String code) {
        log.info("Fetching produit by code: {}", code);

        ProduitEntity produit = produitRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with code: " + code));

        return produitMapper.toDTO(produit);
    }
}
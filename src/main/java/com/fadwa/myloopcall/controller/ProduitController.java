package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.ProduitDTO;
import com.fadwa.myloopcall.service.ProduitService;
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

@RestController
@RequestMapping("${app.api.prefix}/produits")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    public ResponseEntity<ProduitDTO> createProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        log.info("REST request to create produit: {}", produitDTO.getNom());
        ProduitDTO createdProduit = produitService.createProduit(produitDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> updateProduit(
            @PathVariable Long id,
            @Valid @RequestBody ProduitDTO produitDTO) {
        log.info("REST request to update produit with id: {}", id);
        ProduitDTO updatedProduit = produitService.updateProduit(id, produitDTO);
        return ResponseEntity.ok(updatedProduit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        log.info("REST request to get produit with id: {}", id);
        ProduitDTO produit = produitService.getProduitById(id);
        return ResponseEntity.ok(produit);
    }


    @GetMapping
    public ResponseEntity<Page<ProduitDTO>> getAllProduitsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "nom") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("ASC")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ProduitDTO> produits = produitService.getAllProduits(pageable);

        return ResponseEntity.ok(produits);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        log.info("REST request to delete produit with id: {}", id);
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<ProduitDTO>> getActiveProduits() {
        log.info("REST request to get active produits");
        List<ProduitDTO> produits = produitService.getActiveProduits();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProduitDTO>> searchProduits(@RequestParam String nom) {
        log.info("REST request to search produits by nom: {}", nom);
        List<ProduitDTO> produits = produitService.searchProduitsByNom(nom);
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ProduitDTO> getProduitByNom(@PathVariable String nom) {
        log.info("REST request to get produit by nom: {}", nom);
        ProduitDTO produit = produitService.getProduitByNom(nom);
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ProduitDTO> getProduitByCode(@PathVariable String code) {
        log.info("REST request to get produit by code: {}", code);
        ProduitDTO produit = produitService.getProduitByCode(code);
        return ResponseEntity.ok(produit);
    }
}
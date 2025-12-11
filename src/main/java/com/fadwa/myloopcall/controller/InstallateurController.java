package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.InstallateurDTO;
import com.fadwa.myloopcall.service.InstallateurService;
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
@RequestMapping("${app.api.prefix}/installateurs")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class InstallateurController {

    private final InstallateurService installateurService;

    @PostMapping
    public ResponseEntity<InstallateurDTO> createInstallateur(@Valid @RequestBody InstallateurDTO installateurDTO) {
        log.info("REST request to create installateur: {}", installateurDTO.getNom());
        InstallateurDTO createdInstallateur = installateurService.createInstallateur(installateurDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstallateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstallateurDTO> updateInstallateur(
            @PathVariable Long id,
            @Valid @RequestBody InstallateurDTO installateurDTO) {
        log.info("REST request to update installateur with id: {}", id);
        InstallateurDTO updatedInstallateur = installateurService.updateInstallateur(id, installateurDTO);
        return ResponseEntity.ok(updatedInstallateur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstallateurDTO> getInstallateurById(@PathVariable Long id) {
        log.info("REST request to get installateur with id: {}", id);
        InstallateurDTO installateur = installateurService.getInstallateurById(id);
        return ResponseEntity.ok(installateur);
    }

    @GetMapping
    public ResponseEntity<List<InstallateurDTO>> getAllInstallateurs() {
        log.info("REST request to get all installateurs");
        List<InstallateurDTO> installateurs = installateurService.getAllInstallateurs();
        return ResponseEntity.ok(installateurs);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<InstallateurDTO>> getAllInstallateursPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "nom") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("ASC")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<InstallateurDTO> installateurs = installateurService.getAllInstallateurs(pageable);

        return ResponseEntity.ok(installateurs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstallateur(@PathVariable Long id) {
        log.info("REST request to delete installateur with id: {}", id);
        installateurService.deleteInstallateur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<InstallateurDTO>> getActiveInstallateurs() {
        log.info("REST request to get active installateurs");
        List<InstallateurDTO> installateurs = installateurService.getActiveInstallateurs();
        return ResponseEntity.ok(installateurs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<InstallateurDTO>> searchInstallateurs(@RequestParam String nom) {
        log.info("REST request to search installateurs by nom: {}", nom);
        List<InstallateurDTO> installateurs = installateurService.searchInstallateursByNom(nom);
        return ResponseEntity.ok(installateurs);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<InstallateurDTO> getInstallateurByNom(@PathVariable String nom) {
        log.info("REST request to get installateur by nom: {}", nom);
        InstallateurDTO installateur = installateurService.getInstallateurByNom(nom);
        return ResponseEntity.ok(installateur);
    }

    @GetMapping("/ville/{ville}")
    public ResponseEntity<List<InstallateurDTO>> getInstallateursByVille(@PathVariable String ville) {
        log.info("REST request to get installateurs by ville: {}", ville);
        List<InstallateurDTO> installateurs = installateurService.getInstallateursByVille(ville);
        return ResponseEntity.ok(installateurs);
    }

    @GetMapping("/siret/{siret}")
    public ResponseEntity<InstallateurDTO> getInstallateurBySiret(@PathVariable String siret) {
        log.info("REST request to get installateur by siret: {}", siret);
        InstallateurDTO installateur = installateurService.getInstallateurBySiret(siret);
        return ResponseEntity.ok(installateur);
    }
}
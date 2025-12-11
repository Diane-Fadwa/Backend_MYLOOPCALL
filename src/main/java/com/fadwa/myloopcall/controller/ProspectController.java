package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.ProspectDTO;
import com.fadwa.myloopcall.enums.StatutEnum;
import com.fadwa.myloopcall.service.ProspectService;
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
@RequestMapping("${app.api.prefix}/prospects")
@RequiredArgsConstructor
@Slf4j
public class ProspectController {

    private final ProspectService prospectService;

    /**
     * Create a new prospect
     * POST /api/prospects
     */
    @PostMapping
    public ResponseEntity<ProspectDTO> createProspect(@Valid @RequestBody ProspectDTO prospectDTO) {
        log.info("REST request to create prospect: {} {}", prospectDTO.getNom(), prospectDTO.getPrenom());
        ProspectDTO createdProspect = prospectService.createProspect(prospectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProspect);
    }

    /**
     * Update an existing prospect
     * PUT /api/prospects/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProspectDTO> updateProspect(
            @PathVariable Long id,
            @Valid @RequestBody ProspectDTO prospectDTO) {
        log.info("REST request to update prospect with id: {}", id);
        ProspectDTO updatedProspect = prospectService.updateProspect(id, prospectDTO);
        return ResponseEntity.ok(updatedProspect);
    }

    /**
     * Get a prospect by id
     * GET /api/prospects/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProspectDTO> getProspectById(@PathVariable Long id) {
        log.info("REST request to get prospect with id: {}", id);
        ProspectDTO prospect = prospectService.getProspectById(id);
        return ResponseEntity.ok(prospect);
    }


    /**
     * Get all prospects with pagination
     * GET /api/prospects/paginated?page=0&size=50&sort=date,desc
     */
    @GetMapping("/paginated")
    public ResponseEntity<Page<ProspectDTO>> getAllProspectsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDir) {

        log.info("REST request to get prospects with pagination: page={}, size={}", page, size);

        Sort sort = sortDir.equalsIgnoreCase("ASC")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ProspectDTO> prospects = prospectService.getAllProspects(pageable);

        return ResponseEntity.ok(prospects);
    }

    /**
     * Delete a prospect
     * DELETE /api/prospects/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProspect(@PathVariable Long id) {
        log.info("REST request to delete prospect with id: {}", id);
        prospectService.deleteProspect(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search prospects by name, prenom, or phone number
     * GET /api/prospects/search?term=john
     */
    @GetMapping("/search")
    public ResponseEntity<List<ProspectDTO>> searchProspects(
            @RequestParam String term) {
        log.info("REST request to search prospects with term: {}", term);
        List<ProspectDTO> prospects = prospectService.searchProspects(term);
        return ResponseEntity.ok(prospects);
    }

    /**
     * Filter prospects by multiple criteria
     * GET /api/prospects/filter?agent=DIBA&statut=VALIDE&page=0&size=50
     */
    @GetMapping("/filter")
    public ResponseEntity<Page<ProspectDTO>> filterProspects(
            @RequestParam(required = false) String agent,
            @RequestParam(required = false) String confirmateur,
            @RequestParam(required = false) StatutEnum statut,
            @RequestParam(required = false) String produit,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDir) {

        log.info("REST request to filter prospects");

        Sort sort = sortDir.equalsIgnoreCase("ASC")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ProspectDTO> prospects = prospectService.filterProspects(
                agent, confirmateur, statut, produit, search, pageable
        );

        return ResponseEntity.ok(prospects);
    }

    /**
     * Filter prospects without pagination
     * GET /api/prospects/filter/all?agent=DIBA&statut=VALIDE
     */
    @GetMapping("/filter/all")
    public ResponseEntity<List<ProspectDTO>> filterProspectsAll(
            @RequestParam(required = false) String agent,
            @RequestParam(required = false) String confirmateur,
            @RequestParam(required = false) StatutEnum statut,
            @RequestParam(required = false) String produit,
            @RequestParam(required = false) String search) {

        log.info("REST request to filter all prospects");

        List<ProspectDTO> prospects = prospectService.filterProspects(
                agent, confirmateur, statut, produit, search
        );

        return ResponseEntity.ok(prospects);
    }
}
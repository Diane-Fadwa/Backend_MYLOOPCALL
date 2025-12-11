package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.ProspectDTO;
import com.fadwa.myloopcall.enums.StatutEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProspectService {

    /**
     * Create a new prospect
     * @param prospectDTO the prospect to create
     * @return the created prospect
     */
    ProspectDTO createProspect(ProspectDTO prospectDTO);

    /**
     * Update an existing prospect
     * @param id the prospect id
     * @param prospectDTO the prospect data to update
     * @return the updated prospect
     */
    ProspectDTO updateProspect(Long id, ProspectDTO prospectDTO);

    /**
     * Get a prospect by id
     * @param id the prospect id
     * @return the prospect
     */
    ProspectDTO getProspectById(Long id);

    /**
     * Get all prospects
     * @return list of all prospects
     */

    Page<ProspectDTO> getAllProspects(Pageable pageable);

    /**
     * Delete a prospect
     * @param id the prospect id
     */
    void deleteProspect(Long id);

    /**
     * Search prospects by name, prenom, or phone number
     * @param searchTerm the search term
     * @return list of matching prospects
     */
    List<ProspectDTO> searchProspects(String searchTerm);

    /**
     * Filter prospects by various criteria
     * @param agent the agent filter
     * @param confirmateur the confirmateur filter
     * @param statut the statut filter
     * @param produit the produit filter
     * @param searchTerm the search term
     * @return list of filtered prospects
     */
    List<ProspectDTO> filterProspects(
            String agent,
            String confirmateur,
            StatutEnum statut,
            String produit,
            String searchTerm
    );

    /**
     * Filter prospects with pagination
     * @param agent the agent filter
     * @param confirmateur the confirmateur filter
     * @param statut the statut filter
     * @param produit the produit filter
     * @param searchTerm the search term
     * @param pageable pagination information
     * @return page of filtered prospects
     */
    Page<ProspectDTO> filterProspects(
            String agent,
            String confirmateur,
            StatutEnum statut,
            String produit,
            String searchTerm,
            Pageable pageable
    );
}
package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.ProspectDTO;
import com.fadwa.myloopcall.entity.ProspectEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.ProspectMapper;
import com.fadwa.myloopcall.repository.ProspectRepository;
import com.fadwa.myloopcall.service.ProspectService;
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
public class ProspectServiceImpl implements ProspectService {

    private final ProspectRepository prospectRepository;
    private final ProspectMapper prospectMapper;

    @Override
    public ProspectDTO createProspect(ProspectDTO prospectDTO) {
        log.info("Creating new prospect: {} {}", prospectDTO.getNom(), prospectDTO.getPrenom());

        ProspectEntity prospect = prospectMapper.toEntity(prospectDTO);
        ProspectEntity savedProspect = prospectRepository.save(prospect);

        log.info("Prospect created successfully with id: {}", savedProspect.getId());
        return prospectMapper.toDTO(savedProspect);
    }

    @Override
    public ProspectDTO updateProspect(Long id, ProspectDTO prospectDTO) {
        log.info("Updating prospect with id: {}", id);

        ProspectEntity existingProspect = prospectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prospect not found with id: " + id));

        prospectMapper.updateEntityFromDTO(prospectDTO, existingProspect);
        ProspectEntity updatedProspect = prospectRepository.save(existingProspect);

        log.info("Prospect updated successfully with id: {}", id);
        return prospectMapper.toDTO(updatedProspect);
    }

    @Override
    @Transactional(readOnly = true)
    public ProspectDTO getProspectById(Long id) {
        log.info("Fetching prospect with id: {}", id);

        ProspectEntity prospect = prospectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prospect not found with id: " + id));

        return prospectMapper.toDTO(prospect);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProspectDTO> getAllProspects() {
        log.info("Fetching all prospects");

        List<ProspectEntity> prospects = prospectRepository.findAll();
        return prospectMapper.toDTOList(prospects);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProspectDTO> getAllProspects(Pageable pageable) {
        log.info("Fetching prospects with pagination: page {}, size {}",
                pageable.getPageNumber(), pageable.getPageSize());

        Page<ProspectEntity> prospects = prospectRepository.findAll(pageable);
        return prospects.map(prospectMapper::toDTO);
    }

    @Override
    public void deleteProspect(Long id) {
        log.info("Deleting prospect with id: {}", id);

        if (!prospectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Prospect not found with id: " + id);
        }

        prospectRepository.deleteById(id);
        log.info("Prospect deleted successfully with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProspectDTO> searchProspects(String searchTerm) {
        log.info("Searching prospects with term: {}", searchTerm);

        List<ProspectEntity> prospects = prospectRepository.searchProspects(searchTerm);
        return prospectMapper.toDTOList(prospects);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProspectDTO> filterProspects(
            String agent,
            String confirmateur,
            String statut,
            String produit,
            String searchTerm) {

        log.info("Filtering prospects with criteria - agent: {}, confirmateur: {}, statut: {}, produit: {}, search: {}",
                agent, confirmateur, statut, produit, searchTerm);

        List<ProspectEntity> prospects = prospectRepository.findByFilters(
                agent != null && !agent.isEmpty() ? agent : null,
                confirmateur != null && !confirmateur.isEmpty() ? confirmateur : null,
                statut != null && !statut.isEmpty() ? statut : null,
                produit != null && !produit.isEmpty() ? produit : null,
                searchTerm != null && !searchTerm.isEmpty() ? searchTerm : null
        );

        return prospectMapper.toDTOList(prospects);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProspectDTO> filterProspects(
            String agent,
            String confirmateur,
            String statut,
            String produit,
            String searchTerm,
            Pageable pageable) {

        log.info("Filtering prospects with pagination - page: {}, size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        List<ProspectEntity> prospects = prospectRepository.findByFilters(
                agent != null && !agent.isEmpty() ? agent : null,
                confirmateur != null && !confirmateur.isEmpty() ? confirmateur : null,
                statut != null && !statut.isEmpty() ? statut : null,
                produit != null && !produit.isEmpty() ? produit : null,
                searchTerm != null && !searchTerm.isEmpty() ? searchTerm : null
        );

        // Manual pagination since we're using a custom query
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), prospects.size());

        List<ProspectDTO> prospectDTOs = prospectMapper.toDTOList(
                prospects.subList(start, end)
        );

        return new org.springframework.data.domain.PageImpl<>(
                prospectDTOs,
                pageable,
                prospects.size()
        );
    }
}
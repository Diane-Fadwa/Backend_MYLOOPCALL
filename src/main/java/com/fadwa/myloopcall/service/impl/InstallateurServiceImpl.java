package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.InstallateurDTO;
import com.fadwa.myloopcall.entity.InstallateurEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.InstallateurMapper;
import com.fadwa.myloopcall.repository.InstallateurRepository;
import com.fadwa.myloopcall.service.InstallateurService;
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
public class InstallateurServiceImpl implements InstallateurService {

    private final InstallateurRepository installateurRepository;
    private final InstallateurMapper installateurMapper;

    @Override
    public InstallateurDTO createInstallateur(InstallateurDTO installateurDTO) {
        log.info("Creating new installateur: {}", installateurDTO.getNom());

        if (installateurRepository.existsByNom(installateurDTO.getNom())) {
            throw new IllegalArgumentException("Un installateur avec ce nom existe déjà");
        }

        InstallateurEntity installateur = installateurMapper.toEntity(installateurDTO);
        InstallateurEntity savedInstallateur = installateurRepository.save(installateur);

        log.info("Installateur created successfully with id: {}", savedInstallateur.getId());
        return installateurMapper.toDTO(savedInstallateur);
    }

    @Override
    public InstallateurDTO updateInstallateur(Long id, InstallateurDTO installateurDTO) {
        log.info("Updating installateur with id: {}", id);

        InstallateurEntity existingInstallateur = installateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Installateur not found with id: " + id));

        installateurMapper.updateEntityFromDTO(installateurDTO, existingInstallateur);
        InstallateurEntity updatedInstallateur = installateurRepository.save(existingInstallateur);

        log.info("Installateur updated successfully with id: {}", id);
        return installateurMapper.toDTO(updatedInstallateur);
    }

    @Override
    @Transactional(readOnly = true)
    public InstallateurDTO getInstallateurById(Long id) {
        log.info("Fetching installateur with id: {}", id);

        InstallateurEntity installateur = installateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Installateur not found with id: " + id));

        return installateurMapper.toDTO(installateur);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstallateurDTO> getAllInstallateurs() {
        log.info("Fetching all installateurs");
        List<InstallateurEntity> installateurs = installateurRepository.findAll();
        return installateurMapper.toDTOList(installateurs);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InstallateurDTO> getAllInstallateurs(Pageable pageable) {
        log.info("Fetching installateurs with pagination");
        Page<InstallateurEntity> installateurs = installateurRepository.findAll(pageable);
        return installateurs.map(installateurMapper::toDTO);
    }

    @Override
    public void deleteInstallateur(Long id) {
        log.info("Deleting installateur with id: {}", id);

        if (!installateurRepository.existsById(id)) {
            throw new ResourceNotFoundException("Installateur not found with id: " + id);
        }

        installateurRepository.deleteById(id);
        log.info("Installateur deleted successfully with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstallateurDTO> getActiveInstallateurs() {
        log.info("Fetching active installateurs");
        List<InstallateurEntity> installateurs = installateurRepository.findByActif(true);
        return installateurMapper.toDTOList(installateurs);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstallateurDTO> searchInstallateursByNom(String nom) {
        log.info("Searching installateurs by nom: {}", nom);
        List<InstallateurEntity> installateurs = installateurRepository.findByNomContainingIgnoreCase(nom);
        return installateurMapper.toDTOList(installateurs);
    }

    @Override
    @Transactional(readOnly = true)
    public InstallateurDTO getInstallateurByNom(String nom) {
        log.info("Fetching installateur by nom: {}", nom);

        InstallateurEntity installateur = installateurRepository.findByNom(nom)
                .orElseThrow(() -> new ResourceNotFoundException("Installateur not found with nom: " + nom));

        return installateurMapper.toDTO(installateur);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstallateurDTO> getInstallateursByVille(String ville) {
        log.info("Fetching installateurs by ville: {}", ville);
        List<InstallateurEntity> installateurs = installateurRepository.findByVille(ville);
        return installateurMapper.toDTOList(installateurs);
    }

    @Override
    @Transactional(readOnly = true)
    public InstallateurDTO getInstallateurBySiret(String siret) {
        log.info("Fetching installateur by siret: {}", siret);

        InstallateurEntity installateur = installateurRepository.findBySiret(siret)
                .orElseThrow(() -> new ResourceNotFoundException("Installateur not found with siret: " + siret));

        return installateurMapper.toDTO(installateur);
    }
}
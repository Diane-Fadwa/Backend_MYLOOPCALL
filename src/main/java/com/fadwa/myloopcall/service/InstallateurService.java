package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.InstallateurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstallateurService {

    InstallateurDTO createInstallateur(InstallateurDTO installateurDTO);

    InstallateurDTO updateInstallateur(Long id, InstallateurDTO installateurDTO);

    InstallateurDTO getInstallateurById(Long id);

    List<InstallateurDTO> getAllInstallateurs();

    Page<InstallateurDTO> getAllInstallateurs(Pageable pageable);

    void deleteInstallateur(Long id);

    List<InstallateurDTO> getActiveInstallateurs();

    List<InstallateurDTO> searchInstallateursByNom(String nom);

    InstallateurDTO getInstallateurByNom(String nom);

    List<InstallateurDTO> getInstallateursByVille(String ville);

    InstallateurDTO getInstallateurBySiret(String siret);
}
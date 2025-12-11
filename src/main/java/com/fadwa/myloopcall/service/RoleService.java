package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.RoleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    RoleDTO getRoleById(Long id);

    List<RoleDTO> getAllRoles();

    Page<RoleDTO> getAllRoles(Pageable pageable);

    void deleteRole(Long id);

    RoleDTO getRoleByNom(String nom);
}
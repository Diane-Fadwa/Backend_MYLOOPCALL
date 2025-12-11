package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.RoleDTO;
import com.fadwa.myloopcall.entity.RoleEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.RoleMapper;
import com.fadwa.myloopcall.repository.RoleRepository;
import com.fadwa.myloopcall.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

//    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
//
//    @Override
//    public RoleDTO createRole(RoleDTO roleDTO) {
//        log.info("Creating new role: {}", roleDTO.getNom());
//
//        if (roleRepository.existsByNom(roleDTO.getNom())) {
//            throw new IllegalArgumentException("Un rôle avec ce nom existe déjà");
//        }
//
//        RoleEntity role = roleMapper.toEntity(roleDTO);
//        RoleEntity savedRole = roleRepository.save(role);
//
//        log.info("Role created successfully with id: {}", savedRole.getId());
//        return roleMapper.toDTO(savedRole);
//    }
//
//    @Override
//    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
//        log.info("Updating role with id: {}", id);
//
//        RoleEntity existingRole = roleRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
//
//        roleMapper.updateEntityFromDTO(roleDTO, existingRole);
//        RoleEntity updatedRole = roleRepository.save(existingRole);
//
//        log.info("Role updated successfully with id: {}", id);
//        return roleMapper.toDTO(updatedRole);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public RoleDTO getRoleById(Long id) {
//        log.info("Fetching role with id: {}", id);
//
//        RoleEntity role = roleRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
//
//        return roleMapper.toDTO(role);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<RoleDTO> getAllRoles() {
//        log.info("Fetching all roles");
//        List<RoleEntity> roles = roleRepository.findAll();
//        return roleMapper.toDTOList(roles);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Page<RoleDTO> getAllRoles(Pageable pageable) {
//        log.info("Fetching roles with pagination");
//        Page<RoleEntity> roles = roleRepository.findAll(pageable);
//        return roles.map(roleMapper::toDTO);
//    }
//
//    @Override
//    public void deleteRole(Long id) {
//        log.info("Deleting role with id: {}", id);
//
//        if (!roleRepository.existsById(id)) {
//            throw new ResourceNotFoundException("Role not found with id: " + id);
//        }
//
//        roleRepository.deleteById(id);
//        log.info("Role deleted successfully with id: {}", id);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public RoleDTO getRoleByNom(String nom) {
//        log.info("Fetching role by nom: {}", nom);
//
//        RoleEntity role = roleRepository.findByNom(nom)
//                .orElseThrow(() -> new ResourceNotFoundException("Role not found with nom: " + nom));
//
//        return roleMapper.toDTO(role);
//    }
}
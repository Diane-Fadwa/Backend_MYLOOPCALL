package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.RoleDTO;
import com.fadwa.myloopcall.security.AdminOnly;
import com.fadwa.myloopcall.service.RoleService;
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
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@AdminOnly
public class RoleController {

//    private final RoleService roleService;
//
//    @PostMapping
//    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) {
//        log.info("REST request to create role: {}", roleDTO.getNom());
//        RoleDTO createdRole = roleService.createRole(roleDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<RoleDTO> updateRole(
//            @PathVariable Long id,
//            @Valid @RequestBody RoleDTO roleDTO) {
//        log.info("REST request to update role with id: {}", id);
//        RoleDTO updatedRole = roleService.updateRole(id, roleDTO);
//        return ResponseEntity.ok(updatedRole);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
//        log.info("REST request to get role with id: {}", id);
//        RoleDTO role = roleService.getRoleById(id);
//        return ResponseEntity.ok(role);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<RoleDTO>> getAllRoles() {
//        log.info("REST request to get all roles");
//        List<RoleDTO> roles = roleService.getAllRoles();
//        return ResponseEntity.ok(roles);
//    }
//
//    @GetMapping("/paginated")
//    public ResponseEntity<Page<RoleDTO>> getAllRolesPaginated(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "50") int size,
//            @RequestParam(defaultValue = "nom") String sortBy,
//            @RequestParam(defaultValue = "ASC") String sortDir) {
//
//        Sort sort = sortDir.equalsIgnoreCase("ASC")
//                ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();
//
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<RoleDTO> roles = roleService.getAllRoles(pageable);
//
//        return ResponseEntity.ok(roles);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
//        log.info("REST request to delete role with id: {}", id);
//        roleService.deleteRole(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/nom/{nom}")
//    public ResponseEntity<RoleDTO> getRoleByNom(@PathVariable String nom) {
//        log.info("REST request to get role by nom: {}", nom);
//        RoleDTO role = roleService.getRoleByNom(nom);
//        return ResponseEntity.ok(role);
//    }
}
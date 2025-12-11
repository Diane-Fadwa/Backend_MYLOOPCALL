package com.fadwa.myloopcall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;
//
//    @Column(name = "description")
//    private String description;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"))
//    private Set<Permission> permissions = new HashSet<>();
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
//
//    @Embeddable
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class Permission {
//        @Column(name = "page")
//        private String page;
//
//        @Column(name = "can_view")
//        private Boolean canView = false;
//
//        @Column(name = "can_edit")
//        private Boolean canEdit = false;
//    }
}
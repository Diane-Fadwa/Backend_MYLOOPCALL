package com.fadwa.myloopcall.entity;

import com.fadwa.myloopcall.enums.StatutEnum;
import com.fadwa.myloopcall.enums.ZoneEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "Prospect")
@Table(name = "prospects")
@NoArgsConstructor
@AllArgsConstructor
public class ProspectEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private LocalDateTime rappelLe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id", nullable = false)
    private ProduitEntity produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    private AgentEntity agent;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ZoneEnum zone;

    @Column(nullable = false)
    private String profil;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String adresse;

    @Column(length = 10)
    private String codePostal;

    private String ville;

    @Column(nullable = false, length = 15)
    private String numeroMobile;

    @Column(length = 1000)
    private String commentaire;

    @Column(nullable = false)
    private String confirmateur;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatutEnum statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "installateur_id", nullable = false)
    private InstallateurEntity installateur;
}

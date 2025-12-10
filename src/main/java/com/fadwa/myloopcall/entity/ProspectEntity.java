package com.fadwa.myloopcall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Builder
@Entity(name = "Prospect")
@Table(name = "prospects")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProspectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "rappel_le")
    private LocalDate rappelLe;

    @Column(name = "heure")
    private String heure;

    @Column(name = "produit", nullable = false)
    private String produit;

    @Column(name = "agent", nullable = false)
    private String agent;

    @Column(name = "zone", nullable = false)
    private String zone;

    @Column(name = "profil", nullable = false)
    private String profil;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "numero_mobile", nullable = false)
    private String numeroMobile;

    @Column(name = "commentaire", length = 1000)
    private String commentaire;

    @Column(name = "confirmateur", nullable = false)
    private String confirmateur;

    @Column(name = "statut", nullable = false)
    private String statut;

    @Column(name = "installateur", nullable = false)
    private String installateur;
}

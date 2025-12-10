package com.fadwa.myloopcall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProspectDTO {

    private Long id;

    private LocalDate date;

    private LocalDate rappelLe;

    private String heure;

    @NotBlank(message = "Produit is required")
    private String produit;

    @NotBlank(message = "Agent is required")
    private String agent;

    @NotBlank(message = "Zone is required")
    private String zone;

    @NotBlank(message = "Profil is required")
    private String profil;

    @NotBlank(message = "Nom is required")
    private String nom;

    @NotBlank(message = "Prenom is required")
    private String prenom;

    private String adresse;

    private String codePostal;

    private String ville;

    @NotBlank(message = "Numero mobile is required")
    private String numeroMobile;

    private String commentaire;

    @NotBlank(message = "Confirmateur is required")
    private String confirmateur;

    @NotBlank(message = "Statut is required")
    private String statut;

    @NotBlank(message = "Installateur is required")
    private String installateur;
}
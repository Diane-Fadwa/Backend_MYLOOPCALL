package com.fadwa.myloopcall.dto;

import com.fadwa.myloopcall.enums.StatutEnum;
import com.fadwa.myloopcall.enums.ZoneEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProspectDTO {

    private Long id;

    private LocalDateTime date;

    private LocalDateTime rappelLe;

//    @NotBlank(message = "Produit is required")
    private ProduitDTO produit;

//    @NotBlank(message = "Agent is required")
    private AgentDTO agent;

//    @NotBlank(message = "Zone is required")
    private ZoneEnum zone;

//    @NotBlank(message = "Profil is required")
    private String profil;

//    @NotBlank(message = "Nom is required")
    private String nom;

//    @NotBlank(message = "Prenom is required")
    private String prenom;

    private String adresse;

    private Integer codePostal;

    private String ville;

//    @NotBlank(message = "Numero mobile is required")
    private Integer numeroMobile;

    private String commentaire;

//    @NotBlank(message = "Confirmateur is required")
    private String confirmateur;

//    @NotBlank(message = "Statut is required")
    private StatutEnum statut;

//    @NotBlank(message = "Installateur is required")
    private InstallateurDTO installateur;
}
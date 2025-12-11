package com.fadwa.myloopcall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstallateurDTO {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Email(message = "Email invalide")
    private String email;

    private String telephone;

    private String adresse;

    private String ville;

    private String codePostal;

    private String siret;

    private Boolean actif = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
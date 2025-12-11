package com.fadwa.myloopcall.entity;


import com.fadwa.myloopcall.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tools.jackson.core.ObjectReadContext;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;

    private String lastName;


    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Role cannot be null")
    private RoleEnum role;


    private String profileImage;


//    private Boolean isVerified = false;

    @Column(unique = true ,name = "verification_token")
    private String verificationToken;

    @Column(unique = true)
    private String passwordToken;

    private Instant tokenExpiry;


}
package com.pokegacha.main.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String username;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    // MONEDAS
    @Column(nullable = false)
    private int coins = 1000;

    // ESTADÍSTICAS
    @Column(nullable = false)
    private int totalCartas = 0;

    @Column(nullable = false)
    private int totalTiradas = 0;

    // LISTA DE CARTAS (guarda IDs como string)
    @Column(columnDefinition = "TEXT")
    private String cardsList = "";
}

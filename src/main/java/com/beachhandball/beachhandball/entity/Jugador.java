package com.beachhandball.beachhandball.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table (name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    @NotBlank
    private String nombre;
    @Column (nullable = false)
    @Min(value = 6)
    private int edad;
    @Column (nullable = false)
    @NotBlank
    private String especialidad;
    @ManyToOne
    @JoinColumn (name = "equipo_id")
    private Equipo equipo;
}

package com.beachhandball.beachhandball.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table ( name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    @NotBlank
    private String nombre;
    @Column (nullable = false)
    @NotBlank
    private String genero;
    @Column (nullable = false)
    @NotBlank
    private int tamañoPlantilla;

}

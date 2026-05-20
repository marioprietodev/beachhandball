package com.beachhandball.beachhandball.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

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
    @Min(value = 1)
    private int tamañoPlantilla;
    @OneToMany (mappedBy = "equipo")
    private List<Jugador>plantilla;


}

package com.beachhandball.beachhandball.dto;

import com.beachhandball.beachhandball.entity.Equipo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JugadorRequestDTO {


    @NotBlank
    private String nombre;
    @Min(value = 6)
    private int edad;
    @NotBlank
    private String especialidad;
    @NotNull
    private Long equipoId;
}

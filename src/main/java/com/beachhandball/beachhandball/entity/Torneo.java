package com.beachhandball.beachhandball.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String nombre;
    @Column (nullable = false)
    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha;
    @Column ( nullable = false)
    @NotBlank
    private String lugar;


}

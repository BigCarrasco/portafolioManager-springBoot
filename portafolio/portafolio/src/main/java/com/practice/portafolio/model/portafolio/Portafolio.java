package com.practice.portafolio.model.portafolio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "portafolio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portafolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_proyecto", nullable = false, length = 255) //name = especifica  el nombre de la columna directamente
    private String nombreProyecto;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(name = "tecnologias_usadas", length = 255)
    private String tecnologiasUsadas;

    @Column(name = "url_proyecto")
    private String urlProyecto;
}

package com.practice.portafolioManager.dto.portafolio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PortafolioResponseDTO {
    private Long id;
    private String nombreProyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tecnologiasUsadas;
    private String urlProyecto;
}
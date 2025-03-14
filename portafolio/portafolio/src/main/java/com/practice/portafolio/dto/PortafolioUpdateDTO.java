package com.practice.portafolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PortafolioUpdateDTO {
    private String nombreProyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tecnologiasUsadas;
    private String urlProyecto;
}

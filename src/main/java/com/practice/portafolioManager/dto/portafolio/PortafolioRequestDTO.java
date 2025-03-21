package com.practice.portafolioManager.dto.portafolio;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PortafolioRequestDTO {
    private String nombreProyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tecnologiasUsadas;
    private String urlProyecto;
}
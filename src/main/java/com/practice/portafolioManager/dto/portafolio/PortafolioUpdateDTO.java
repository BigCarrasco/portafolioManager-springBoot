package com.practice.portafolioManager.dto.portafolio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PortafolioUpdateDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombreProyecto;

    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tecnologiasUsadas;
    private String urlProyecto;
}

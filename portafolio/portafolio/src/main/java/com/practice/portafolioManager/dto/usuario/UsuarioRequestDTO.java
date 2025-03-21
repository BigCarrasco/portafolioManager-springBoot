package com.practice.portafolioManager.dto.usuario;

public record UsuarioRequestDTO(
        String nombre,
        String email,
        int edad
) {
}
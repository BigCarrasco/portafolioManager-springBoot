package com.practice.portafolioManager.dto.usuario;

public record UsuarioResponseDTO(
        String id,
        String nombre,
        String email,
        int edad
) {
}
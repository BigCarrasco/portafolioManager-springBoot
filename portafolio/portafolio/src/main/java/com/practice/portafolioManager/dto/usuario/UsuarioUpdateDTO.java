package com.practice.portafolioManager.dto.usuario;

public record UsuarioUpdateDTO (
        String nombre,
        String email,
        int edad
) {
}
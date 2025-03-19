package com.practice.usuarios.controller;

import com.practice.usuarios.DTOs.UsuarioResponseDTO;
import com.practice.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
    public List<UsuarioResponseDTO> toList(){
        return service.obtenerTodos();
    }
}

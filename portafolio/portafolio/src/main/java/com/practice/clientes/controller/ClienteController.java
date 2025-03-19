package com.practice.clientes.controller;

import com.practice.clientes.DTOs.ClienteRequestDTO;
import com.practice.clientes.DTOs.ClienteResponseDTO;
import com.practice.clientes.service.ClienteService;
import com.practice.portafolio.dto.PortafolioResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/clientes")
    public List<ClienteResponseDTO> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/clientes/{id}")
    public Optional<ClienteResponseDTO> obtenerPorId(@PathVariable Long id) {
        return service.ObtenerPorId(id);
    }

    @PostMapping("/clientes")
    public ClienteResponseDTO guardar(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return service.guardar(clienteRequestDTO);
    }
}

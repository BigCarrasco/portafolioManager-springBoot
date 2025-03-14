package com.practice.portafolio.controller;

import com.practice.portafolio.config.ApiRoutes;
import com.practice.portafolio.dto.PortafolioRequestDTO;
import com.practice.portafolio.dto.PortafolioResponseDTO;
import com.practice.portafolio.dto.PortafolioUpdateDTO;
import com.practice.portafolio.service.PortafolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PortafolioController {
    private final PortafolioService service;

    public PortafolioController(PortafolioService service) {
        this.service = service;
    }

    @GetMapping(ApiRoutes.GET_ALL_PORTAFOLIO)
    public List<PortafolioResponseDTO> toList() {
        return service.obtenerTodos();
    }

    @GetMapping(ApiRoutes.GET_PORTAFOLIO_BY_ID)
    public Optional<PortafolioResponseDTO> getById(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping(ApiRoutes.CREATE_PORTAFOLIO)
    public PortafolioResponseDTO create(@RequestBody PortafolioRequestDTO portafolioRequestDTO) {
        return service.guardar(portafolioRequestDTO);
    }

    @PutMapping(ApiRoutes.UPDATE_PORTAFOLIO)
    public PortafolioResponseDTO update(@PathVariable Long id, @RequestBody PortafolioUpdateDTO updateDTO) {
        return service.actualizar(id, updateDTO);
    }

    @DeleteMapping(ApiRoutes.DELETE_PORTAFOLIO)
    public void delete(@PathVariable Long id)
    {
        service.eliminar(id);
    }
}

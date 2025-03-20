package com.practice.portafolio.controller;

import com.practice.portafolio.config.ApiRoutes;
import com.practice.portafolio.dto.PortafolioRequestDTO;
import com.practice.portafolio.dto.PortafolioResponseDTO;
import com.practice.portafolio.dto.PortafolioUpdateDTO;
import com.practice.portafolio.exception.ResourceNotFoundException;
import com.practice.portafolio.exception.ValidationException;
import com.practice.portafolio.service.PortafolioService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@Validated
public class PortafolioController {
    private final PortafolioService service;
    private static final Logger logger = LogManager.getLogger(PortafolioController.class);

    public PortafolioController(PortafolioService service) {
        this.service = service;
    }

    @GetMapping(ApiRoutes.GET_ALL_PORTAFOLIO)
    public List<PortafolioResponseDTO> toList() {
        //logger.info("Fetching all portfolios");
        return service.obtenerTodos();
    }

    @GetMapping(ApiRoutes.GET_PORTAFOLIO_BY_ID)
    public Optional<PortafolioResponseDTO> getById(@PathVariable Long id) {
        Optional<PortafolioResponseDTO> portafolio = service.obtenerPorId(id);
        if (portafolio.isEmpty()) {
            throw new ResourceNotFoundException("Portafolio not found with id xxx: " + id);
        }
        return portafolio;
    }

    @PostMapping(ApiRoutes.CREATE_PORTAFOLIO)
    public PortafolioResponseDTO create(@RequestBody PortafolioRequestDTO portafolioRequestDTO) {
        if(portafolioRequestDTO.getNombreProyecto() == null || portafolioRequestDTO.getNombreProyecto().isEmpty()){
            logger.error("*** Project name cannot be null or empty ****");
            throw new ValidationException("Nombre del proyecto no puede ser nulo o vacio xxx");
        }
        return service.guardar(portafolioRequestDTO);
    }

    @PutMapping(ApiRoutes.UPDATE_PORTAFOLIO)
    public PortafolioResponseDTO update(@PathVariable Long id,@Valid @RequestBody PortafolioUpdateDTO updateDTO) {
        Optional<PortafolioResponseDTO> portafolio = service.obtenerPorId(id);
        if (portafolio.isEmpty()) {
            throw new ResourceNotFoundException("*** Portafolio not found with id ***: " + id);
        }
        return service.actualizar(id, updateDTO);
    }

    @DeleteMapping(ApiRoutes.DELETE_PORTAFOLIO)
    public void delete(@PathVariable Long id) {
        service.eliminar(id);
    }
}

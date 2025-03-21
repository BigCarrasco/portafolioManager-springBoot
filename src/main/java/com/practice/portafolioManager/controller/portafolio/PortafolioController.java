package com.practice.portafolioManager.controller.portafolio;

import com.practice.portafolioManager.config.routes.ApiRoutes;
import com.practice.portafolioManager.dto.portafolio.PortafolioRequestDTO;
import com.practice.portafolioManager.dto.portafolio.PortafolioResponseDTO;
import com.practice.portafolioManager.dto.portafolio.PortafolioUpdateDTO;
import com.practice.portafolioManager.exception.ResourceNotFoundException;
import com.practice.portafolioManager.exception.ValidationException;
import com.practice.portafolioManager.service.portafolio.PortafolioService;
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
    private final PortafolioService portafolioService;
    private static final Logger logger = LogManager.getLogger(PortafolioController.class);

    public PortafolioController(PortafolioService service) {
        this.portafolioService = service;
    }

    @GetMapping(ApiRoutes.GET_PORTAFOLIO_BY_ID)
    public Optional<PortafolioResponseDTO> getPortafolioById(@PathVariable Long id) {
        Optional<PortafolioResponseDTO> portafolio = portafolioService.getPortafolioById(id);
        if (portafolio.isEmpty()) {
            throw new ResourceNotFoundException("*** Portafolio not found with id ***: " + id);
        }
        return portafolio;
    }

    @PutMapping(ApiRoutes.UPDATE_PORTAFOLIO)
    public PortafolioResponseDTO updatePortafolioById(@PathVariable Long id,@Valid @RequestBody PortafolioUpdateDTO updateDTO) {
        Optional<PortafolioResponseDTO> portafolio = portafolioService.getPortafolioById(id);

        if (portafolio.isEmpty()) {
            throw new ResourceNotFoundException("*** Portafolio not found with id ***: " + id);
        }
        return portafolioService.updatePortafolioById(id, updateDTO);
    }

    @DeleteMapping(ApiRoutes.DELETE_PORTAFOLIO)
    public void deletePortafolioById(@PathVariable Long id) {
        portafolioService.deletePortafolioById(id);
    }

    @GetMapping(ApiRoutes.GET_ALL_PORTAFOLIO)
    public List<PortafolioResponseDTO> getAllPortafolio() {
        return portafolioService.getAllPortafolio();
    }

    @PostMapping(ApiRoutes.CREATE_PORTAFOLIO)
    public PortafolioResponseDTO savePortafolio(@RequestBody PortafolioRequestDTO portafolioRequestDTO) {
        if(portafolioRequestDTO.getNombreProyecto() == null || portafolioRequestDTO.getNombreProyecto().isEmpty()){
            logger.error("*** Project name cannot be null or empty ****");
            throw new ValidationException("*** Nombre del proyecto no puede ser nulo o vacio ***");
        }
        return portafolioService.savePortafolio(portafolioRequestDTO);
    }
}

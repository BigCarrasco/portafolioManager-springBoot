package com.practice.portafolioManager.controller.usuario;

import com.practice.portafolioManager.controller.portafolio.PortafolioController;
import com.practice.portafolioManager.dto.usuario.UsuarioRequestDTO;
import com.practice.portafolioManager.dto.usuario.UsuarioResponseDTO;
import com.practice.portafolioManager.exception.ResourceNotFoundException;
import com.practice.portafolioManager.exception.ValidationException;
import com.practice.portafolioManager.model.usuario.Usuario;
import com.practice.portafolioManager.service.usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongodbAPI/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponseDTO> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public UsuarioResponseDTO guardarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        if(usuarioRequestDTO.nombre() == null || usuarioRequestDTO.nombre().isEmpty()){
            logger.error("*** Project name cannot be null or empty ****");
            throw new ValidationException("*** Nombre del usuario no puede ser nulo o vacio ***");
        }
        return usuarioService.guardarUsuario(usuarioRequestDTO);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioResponseDTO> obtenerPorId(@PathVariable String id) {
        Optional<UsuarioResponseDTO> usuario = usuarioService.obtenerPorId(id);

        if (usuario.isEmpty()) {
            throw new ResourceNotFoundException("*** Usuario not found with id ***: " + id);
        }

        return usuario;
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable String id) {
        return usuarioService.eliminarPorId(id);
    }
}

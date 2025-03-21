package com.practice.portafolioManager.controller.usuario;

import com.practice.portafolioManager.dto.usuario.UsuarioRequestDTO;
import com.practice.portafolioManager.dto.usuario.UsuarioResponseDTO;
import com.practice.portafolioManager.dto.usuario.UsuarioUpdateDTO;
import com.practice.portafolioManager.exception.ResourceNotFoundException;
import com.practice.portafolioManager.exception.ValidationException;
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

    @GetMapping("/{id}")
    public Optional<UsuarioResponseDTO> getUserById(@PathVariable String id) {
        Optional<UsuarioResponseDTO> usuario = usuarioService.getUserById(id);

        if (usuario.isEmpty()) {
            throw new ResourceNotFoundException("*** Usuario not found with id ***: " + id);
        }

        return usuario;
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO updateUserById(@PathVariable String id, @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        Optional<UsuarioResponseDTO> usuario = usuarioService.getUserById(id);

        if (usuario.isEmpty()) {
            throw new ResourceNotFoundException("*** Usuario not found with id ***: " + id);
        }

        return usuarioService.updateUserById(id, usuarioUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable String id) {
        return usuarioService.deleteUserById(id);
    }

    @GetMapping
    public List<UsuarioResponseDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public UsuarioResponseDTO saveUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        if(usuarioRequestDTO.nombre() == null || usuarioRequestDTO.nombre().isEmpty()){
            logger.error("*** Project name cannot be null or empty ****");
            throw new ValidationException("*** Nombre del usuario no puede ser nulo o vacio ***");
        }
        return usuarioService.saveUsuario(usuarioRequestDTO);
    }
}
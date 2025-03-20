package com.practice.portafolio.controller.usuario;

import com.practice.portafolio.model.usuario.Usuario;
import com.practice.portafolio.service.usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongodbAPI/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(String id) {
        return usuarioService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(String id) {
        return usuarioService.eliminarPorId(id);
    }


}

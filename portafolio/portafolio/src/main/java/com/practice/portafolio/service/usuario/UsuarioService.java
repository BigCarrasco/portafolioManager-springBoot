package com.practice.portafolio.service.usuario;

import com.practice.portafolio.model.usuario.Usuario;
import com.practice.portafolio.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuariosRepository) {
        this.usuarioRepository = usuariosRepository;
    }

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(String id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public String eliminarPorId(String id){
        usuarioRepository.deleteById(id);
        return "User Deleted";
    }
}

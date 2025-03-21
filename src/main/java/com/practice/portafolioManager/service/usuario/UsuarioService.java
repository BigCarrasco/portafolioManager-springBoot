package com.practice.portafolioManager.service.usuario;

import com.practice.portafolioManager.dto.usuario.UsuarioRequestDTO;
import com.practice.portafolioManager.dto.usuario.UsuarioResponseDTO;
import com.practice.portafolioManager.model.usuario.Usuario;
import com.practice.portafolioManager.repository.usuario.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuariosRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuariosRepository;
        this.modelMapper = modelMapper;
    }

    public List<UsuarioResponseDTO> getAllUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponseDTO.class))
                .toList();
    }

    public UsuarioResponseDTO saveUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = modelMapper.map(usuarioRequestDTO, Usuario.class);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return modelMapper.map(savedUsuario, UsuarioResponseDTO.class);
    }

    public Optional<UsuarioResponseDTO>getUserById(String id){
        return usuarioRepository.findById(id)
                .map(usuario -> modelMapper.map(usuario, UsuarioResponseDTO.class));
    }

    public String deleteUserById(String id){
        usuarioRepository.deleteById(id);
        return "User Deleted";
    }
}
package com.practice.portafolioManager.config.automapper;

import com.practice.portafolioManager.dto.usuario.UsuarioResponseDTO;
import com.practice.portafolioManager.model.usuario.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        modelMapper.createTypeMap(Usuario.class, UsuarioResponseDTO.class)
                .setConverter(ctx -> {
                    Usuario usuario = ctx.getSource();
                    return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getEdad());
                });

        return modelMapper;
    }

}

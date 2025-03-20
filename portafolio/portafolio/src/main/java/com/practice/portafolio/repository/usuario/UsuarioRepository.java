package com.practice.portafolio.repository.usuario;

import com.practice.portafolio.model.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}

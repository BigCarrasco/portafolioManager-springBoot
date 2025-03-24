package com.practice.portafolioManager.repository.usuario;

import com.practice.portafolioManager.model.portafolio.Portafolio;
import com.practice.portafolioManager.model.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Query("{ '_id': ?0 }")
    Optional<Portafolio> findUsuarioById(String id);
}

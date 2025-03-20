package com.practice.portafolio.model.usuario;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuariosCollection")
public class Usuario {
    @Id
    private String id;

    private String nombre;
    private String email;
    private int edad;

}

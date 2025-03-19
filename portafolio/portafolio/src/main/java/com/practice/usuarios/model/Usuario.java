package com.practice.usuarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor     // Esto asegura que cada vez que se crea un objeto Usuario, se le asignan valores iniciales a estos atributos
@NoArgsConstructor
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String Nombre;

    private String Nickname;
    private long Whatsapp;

    @Column(name = "fecha_registro", nullable = false)
    private Date FechaRegistro;

}

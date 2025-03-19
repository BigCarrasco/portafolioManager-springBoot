package com.practice.usuarios.DTOs;


import java.util.Date;

public class UsuarioResponseDTO {
    private Long Id;
    private String Nombre;
    private String Nickname;
    private long Whatsapp;
    private Date FechaRegistro;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public long getWhatsapp() {
        return Whatsapp;
    }

    public void setWhatsapp(long whatsapp) {
        Whatsapp = whatsapp;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }
}

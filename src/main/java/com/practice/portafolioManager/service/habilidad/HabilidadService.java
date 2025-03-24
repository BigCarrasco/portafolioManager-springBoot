package com.practice.portafolioManager.service.habilidad;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.portafolioManager.model.habilidad.Habilidad;
import com.practice.portafolioManager.repository.habilidades.HabilidadRepository;

@Service
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRespository) {
        this.habilidadRepository = habilidadRespository;
    }

    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.findAll();
    }

    
}
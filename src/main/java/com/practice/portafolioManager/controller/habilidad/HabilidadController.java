package com.practice.portafolioManager.controller.habilidad;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.portafolioManager.model.habilidad.Habilidad;
import com.practice.portafolioManager.service.habilidad.HabilidadService;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController{
    
    private final HabilidadService habilidadService;

    public HabilidadController(HabilidadService habilidadService){
        this.habilidadService = habilidadService;
    }

    @GetMapping
    public List<Habilidad> getAllHabilidades(){
        return habilidadService.getAllHabilidades();
    }

}
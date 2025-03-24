package com.practice.portafolioManager.repository.habilidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.portafolioManager.model.habilidad.Habilidad;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
    
}

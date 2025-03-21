package com.practice.portafolioManager.repository.portafolio;

import com.practice.portafolioManager.model.portafolio.Portafolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortafolioRepository extends JpaRepository<Portafolio, Long>{
}
package com.practice.portafolio.repository;

import com.practice.portafolio.model.Portafolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Interface que sirve para obtener los metodos convencionales CRUD
public interface PortafolioRepository extends JpaRepository<Portafolio, Long>{
}
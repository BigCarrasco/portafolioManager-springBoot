package com.practice.portafolioManager.repository.portafolio;

import com.practice.portafolioManager.model.portafolio.Portafolio;
import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortafolioRepository extends JpaRepository<Portafolio, Long>{
    @Query(value = "SELECT * FROM PORTAFOLIO WHERE Id = :id", nativeQuery = true)
    Optional<Portafolio> findPortafolioById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM PORTAFOLIO WHERE Id = :id", nativeQuery = true)
    void deletePortafolioById(@Param("id") Long id);

}
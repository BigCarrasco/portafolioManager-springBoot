package com.practice.portafolioManager.model.habilidad;

import com.practice.portafolioManager.model.portafolio.Portafolio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habilidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "portafolio_id", referencedColumnName = "id")
    private Portafolio portafolio;
}

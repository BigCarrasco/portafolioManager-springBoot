package com.practice.portafolio.service;

import com.practice.portafolio.dto.PortafolioRequestDTO;
import com.practice.portafolio.dto.PortafolioResponseDTO;
import com.practice.portafolio.dto.PortafolioUpdateDTO;
import com.practice.portafolio.model.Portafolio;
import com.practice.portafolio.repository.PortafolioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

@Service
public class PortafolioService {
    private final PortafolioRepository repository;
    private final ModelMapper modelMapper;

    public PortafolioService(PortafolioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<PortafolioResponseDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(portafolio -> modelMapper.map(portafolio, PortafolioResponseDTO.class)) // Convierte cada entidad a DTO
                .toList();
    }

    @Cacheable(value= "portafolios", key = "'all'")
    public Optional<PortafolioResponseDTO> obtenerPorId(Long id) {
        return repository.findById(id)
                .map(portafolio -> modelMapper.map(portafolio, PortafolioResponseDTO.class));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public PortafolioResponseDTO actualizar(Long id, PortafolioUpdateDTO updateDTO) {
        Optional<Portafolio> optionalPortafolio = repository.findById(id);

        if (optionalPortafolio.isPresent()) {
            Portafolio portafolio = optionalPortafolio.get();

            // Actualizar solo los campos modificables
            modelMapper.map(updateDTO, portafolio);

            // Guardar cambios en la base de datos
            Portafolio updatedPortafolio = repository.save(portafolio);

            // Devolver el objeto actualizado
            return modelMapper.map(updatedPortafolio, PortafolioResponseDTO.class);
        }

        return null; // Opcionalmente lanzar una excepción personalizada
    }


    public PortafolioResponseDTO guardar(PortafolioRequestDTO portafolioRequestDTO) {
        Portafolio portafolio = modelMapper.map(portafolioRequestDTO, Portafolio.class); // Convierte DTO a Entidad
        Portafolio savedPortafolio = repository.save(portafolio);
        return modelMapper.map(savedPortafolio, PortafolioResponseDTO.class); // Convierte Entidad guardada a DTO
    }


}

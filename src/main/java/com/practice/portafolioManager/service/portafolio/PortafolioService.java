package com.practice.portafolioManager.service.portafolio;

import com.practice.portafolioManager.dto.portafolio.PortafolioRequestDTO;
import com.practice.portafolioManager.dto.portafolio.PortafolioResponseDTO;
import com.practice.portafolioManager.dto.portafolio.PortafolioUpdateDTO;
import com.practice.portafolioManager.model.portafolio.Portafolio;
import com.practice.portafolioManager.repository.portafolio.PortafolioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {
    private final PortafolioRepository repository;
    private final ModelMapper modelMapper;

    public PortafolioService(PortafolioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Cacheable(value= "portafolios", key = "'all'")
    public Optional<PortafolioResponseDTO> getPortafolioById(Long id) {
        return repository.findById(id)
                .map(portafolio -> modelMapper.map(portafolio, PortafolioResponseDTO.class));
    }

    public PortafolioResponseDTO updatePortafolioById(Long id, PortafolioUpdateDTO updateDTO) {
        Optional<Portafolio> optionalPortafolio = repository.findById(id);

        if (optionalPortafolio.isPresent()) {
            Portafolio portafolio = optionalPortafolio.get();

            modelMapper.map(updateDTO, portafolio);
            Portafolio updatedPortafolio = repository.save(portafolio);

            return modelMapper.map(updatedPortafolio, PortafolioResponseDTO.class);
        }

        return null; // Opcionalmente lanzar una excepción personalizada
    }

    public void deletePortafolioById(Long id) {
        repository.deleteById(id);
    }

    public List<PortafolioResponseDTO> getAllPortafolio() {
        return repository.findAll()
                .stream()
                .map(portafolio -> modelMapper.map(portafolio, PortafolioResponseDTO.class))
                .toList();
    }

    public PortafolioResponseDTO savePortafolio(PortafolioRequestDTO portafolioRequestDTO) {
        Portafolio portafolio = modelMapper.map(portafolioRequestDTO, Portafolio.class);
        Portafolio savedPortafolio = repository.save(portafolio);
        return modelMapper.map(savedPortafolio, PortafolioResponseDTO.class);
    }
}

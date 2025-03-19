package com.practice.clientes.service;

import com.practice.clientes.DTOs.ClienteRequestDTO;
import com.practice.clientes.DTOs.ClienteResponseDTO;
import com.practice.clientes.model.Cliente;
import com.practice.clientes.repository.ClienteRepository;
import com.practice.portafolio.dto.PortafolioResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository repository, ModelMapper modelMapper)
    {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteResponseDTO> obtenerTodos(){
        return repository.findAll()
                .stream()
                .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class))
                .toList();
    }

    public Optional<ClienteResponseDTO> ObtenerPorId(Long id){
        return repository.findById(id)
                .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class));
    }

    public ClienteResponseDTO guardar(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = modelMapper.map(clienteRequestDTO, Cliente.class);
        Cliente savedCliente = repository.save(cliente);
        return modelMapper.map(savedCliente, ClienteResponseDTO.class);
    }
}

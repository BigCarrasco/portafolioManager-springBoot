package com.practice.portafolioManager.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakerService {
    private final RestTemplate restTemplate;

    public CircuitBreakerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "circuitBreakerService", fallbackMethod = "fallbackMethod")
    public String llamarApiExterna() {
        String url = "http://api.example.com/datos"; // URL de una API externa
        return restTemplate.getForObject(url, String.class);
    }

    // Método de fallback
    public String fallbackMethod(Exception e) {
        return "Servicio no disponible. Por favor, intente más tarde.";
    }
}

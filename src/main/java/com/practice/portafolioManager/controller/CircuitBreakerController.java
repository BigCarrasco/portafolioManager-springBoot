package com.practice.portafolioManager.controller;

import com.practice.portafolioManager.service.CircuitBreakerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit-breaker")
public class CircuitBreakerController {
    private final CircuitBreakerService circuitBreakerService;

    public CircuitBreakerController(CircuitBreakerService circuitBreakerService) {
        this.circuitBreakerService = circuitBreakerService;
    }

    @GetMapping("/llamar-api")
    public String llamarApi() {
        return circuitBreakerService.llamarApiExterna();
    }
}

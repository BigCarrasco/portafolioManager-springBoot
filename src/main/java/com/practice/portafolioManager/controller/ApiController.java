package com.practice.portafolioManager.controller;

import com.practice.portafolioManager.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Es para indicar que es un controlador REST
@RequestMapping("/retryable") // Mapea las clases
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/with/restTemplate")
    public String getData() {
        return apiService.obtenerDatosDesdeApi();
    }
}

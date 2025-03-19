package com.practice.portafolio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class); // Esta linea es para poder hacer logs
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(value = {HttpServerErrorException.class}, maxAttempts = 4, backoff = @Backoff(delay = 2500))
    public String obtenerDatosDesdeApi(){
        logger.info("Llamando a la API");
        String url = "https://api.example.com/datos"; // fake url pa que falle

        return restTemplate.getForObject(url, String.class); // Recibe dos parametros, el primer parametro es la url de la API y el segundo parametro es el tipo de dato que se espera recibir
    }

    @Recover
    public String recuperarError(RestClientException e){ //RestClientException es para manejar errores de cliente
        logger.error("Todos los intentos fallaron: {}", e.getMessage());
        return "No se pudieron obtener los datos. Inténtalo más tarde.";
    }
}

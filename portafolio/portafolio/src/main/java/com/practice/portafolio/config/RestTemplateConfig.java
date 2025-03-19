package com.practice.portafolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Indica que es una clase de configuración
public class RestTemplateConfig {

    @Bean // Indica que es un bean de Spring - contexto de aplicación
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

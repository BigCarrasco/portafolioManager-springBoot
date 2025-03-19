package com.practice.portafolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableAspectJAutoProxy // Habilita aspectos
@EnableRetry // Habilita reintentos
public class PortafolioApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortafolioApplication.class, args);
	}
}

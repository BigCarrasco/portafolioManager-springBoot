package com.practice.portafolioManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRetry
@EnableCaching
public class PortafolioManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortafolioManagerApplication.class, args);
	}
}

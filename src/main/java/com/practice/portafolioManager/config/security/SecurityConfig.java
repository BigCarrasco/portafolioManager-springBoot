package com.practice.portafolioManager.config.security;


import com.practice.portafolioManager.config.utils.JwtAuthentificationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //Sirve para habilitar la seguridad en nuestra aplicación
public class SecurityConfig {

    // Para que meteria los beans?
    // Configuración de la seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthentificationFilter jwtAuthFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // con esto h2 admite el iframe y security no lo reconoce como bicho
                // Autorizacion
                .authorizeHttpRequests(auth -> auth
                        //Protegidos
                        .requestMatchers(
                                "/mongodbAPI/usuarios/protected/**",
                                "/api/portafolio/protected/**",
                                "/api/portafolio/{id}"  // Agregamos la ruta PUT
                        ).authenticated()
                        .anyRequest().permitAll()
                )
                // OAUTH
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/swagger-ui/index.html", true)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(httpBasic -> {});

        return http.build(); // Construir la configuración
    }


    @Bean
    public UserDetailsService userDetailsService() {
        // Crear un usuario en memoria
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Codificar la contraseña porque security necesita de esto
        return new BCryptPasswordEncoder();
    }

}

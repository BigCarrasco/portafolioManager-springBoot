package com.practice.portafolioManager.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //Sirve para habilitar la seguridad en nuestra aplicación
public class SecurityConfig {

    // Para que meteria los beans?
    // Configuración de la seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/api/portafolio/**",
                                "/circuitBreaker/*",
                                "/mongodbAPI/usuarios/**"
                        ).permitAll()
                        //Protegidos
                        .requestMatchers("/api/protected/**").authenticated()
                        .anyRequest().authenticated() // permite a todo lo demás
                )
                .httpBasic(httpBasic -> {}); // Habilitar la autenticación básica
        return http.build(); // Construir la configuración
    }


    @Bean
    public UserDetailsService userDetailsService(){
        // Crear un usuario en memoria
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Codificar la contraseña
        return  new BCryptPasswordEncoder();
    }

}

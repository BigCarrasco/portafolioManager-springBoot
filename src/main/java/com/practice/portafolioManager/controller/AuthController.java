package com.practice.portafolioManager.controller;

import com.practice.portafolioManager.config.utils.JwtUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2User user){
        return user.getAttributes();
    }

    @GetMapping("/token")
    public Map<String, Object> getToken(@AuthenticationPrincipal OAuth2User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getAttribute("name"));
        claims.put("email", user.getAttribute("email"));

        String token = jwtUtil.generateToken(claims);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}

package com.practice.portafolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected/")
public class PublicController {
    @GetMapping("/test")
    public String test() {
        return "Secret key: {4OU52H4ÑO5N42N8CP04857XCTN!HGOE} ";
    }
}

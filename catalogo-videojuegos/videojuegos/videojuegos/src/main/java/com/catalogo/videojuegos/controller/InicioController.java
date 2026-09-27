package com.catalogo.videojuegos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {
    
     @GetMapping("/")
    public String inicio() {
        return " catalogo de videojuegos está vivo";
    }

}

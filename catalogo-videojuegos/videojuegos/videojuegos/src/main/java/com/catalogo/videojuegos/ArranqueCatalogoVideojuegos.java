package com.catalogo.videojuegos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ArranqueCatalogoVideojuegos implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("=== Catálogo de Videojuegos listo ===");
    }
}
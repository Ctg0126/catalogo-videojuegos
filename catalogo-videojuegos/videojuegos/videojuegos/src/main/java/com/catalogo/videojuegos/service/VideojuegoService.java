package com.catalogo.videojuegos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.catalogo.videojuegos.model.Videojuego;

@Service
public class VideojuegoService {

    public List<Videojuego> obtenerVideojuegos() {

        List<Videojuego> videojuegos = new ArrayList<>();

        videojuegos.add(new Videojuego(
                "Minecraft",
                "Supervivencia",
                "PC",
                80000,
                "/imagenes/minecraft.jpg"
        ));

        videojuegos.add(new Videojuego(
                "GTA V",
                "Acción",
                "PC",
                90000,
                "/imagenes/gta5.jpg"
        ));

        videojuegos.add(new Videojuego(
                "EA Sports FC 26",
                "Deportes",
                "PS5",
                250000,
                "/imagenes/fc26.jpg"
        ));

        return videojuegos;
    }
}
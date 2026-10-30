package com.catalogo.videojuegos.controller.dto;

import com.catalogo.videojuegos.model.Videojuego;

public record VideojuegoDTO(Long id, String nombre, String genero, String plataforma, 
    String imagen, double precio ) {

        public static VideojuegoDTO de(Videojuego v){
            return new VideojuegoDTO(v.getId(), v.getNombre(), v.getGenero(), v.getPlataforma(), v.getImagen(), v.getPrecio());
        }

}

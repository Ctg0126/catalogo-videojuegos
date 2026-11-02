package com.catalogo.videojuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.videojuegos.model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    

}

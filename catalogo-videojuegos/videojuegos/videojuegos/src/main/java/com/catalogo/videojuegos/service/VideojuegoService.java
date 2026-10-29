package com.catalogo.videojuegos.service;

import java.util.List;
import java.util.Optional;


import com.catalogo.videojuegos.model.Videojuego;


public interface VideojuegoService {

List<Videojuego> listar();

List<Videojuego> buscarPorNombre(String texto);

Optional<Videojuego> buscar(Long id);
 
Videojuego crear (Videojuego videojuego);

Videojuego editar (Long id, Videojuego videojuego);

void borrar(Long id);

}
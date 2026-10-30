package com.catalogo.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.service.NoEncontradoException;
import com.catalogo.videojuegos.service.VideojuegoService;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController{

private final VideojuegoService servicio;

public VideojuegoController(VideojuegoService servicio) {
    this.servicio = servicio;
}


@GetMapping
public String catalogo(@RequestParam(defaultValue="")String buscar, Model modelo){
    modelo.addAttribute("nombre", servicio.buscarPorNombre(buscar));
    modelo.addAttribute("buscar", buscar);
    return "catalogo"; //templates/catalogo.html
}

@GetMapping("/ficha/{id}")
public String ficha(@PathVariable Long id, Model modelo) {

    Videojuego videojuego = servicio.buscar(id)
            .orElseThrow(() ->
                new NoEncontradoException(
                    "No existe el videojuego " + id
                )
            );

    modelo.addAttribute("videojuego", videojuego);

    return "videojuegos/ficha";
}

@GetMapping("/nuevo")
public String nuevo(Model modelo){
    modelo.addAttribute("videojuego", new Videojuego());
    return "videojuegos/nuevo";

}


}


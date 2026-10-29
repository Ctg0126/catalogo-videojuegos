package com.catalogo.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

}


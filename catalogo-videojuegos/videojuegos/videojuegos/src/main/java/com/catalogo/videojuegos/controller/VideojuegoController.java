package com.catalogo.videojuegos.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalogo.videojuegos.service.Catalogo;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController{

private final Catalogo catalogo;

public VideojuegoController(Catalogo catalogo) {
    this.catalogo = catalogo;
}


@GetMapping
public String catalogo(@RequestParam(defaultValue="")String buscar, Model modelo){
    
    List <String> encontrados = catalogo.TITULOS().stream()
    .filter(t -> t.toLowerCase().contains(buscar.toLowerCase())).toList();

    modelo.addAttribute("titulos", encontrados);
    modelo.addAttribute("buscar", buscar);
    return "catalogo"; //templates/catalogo.html
}

}


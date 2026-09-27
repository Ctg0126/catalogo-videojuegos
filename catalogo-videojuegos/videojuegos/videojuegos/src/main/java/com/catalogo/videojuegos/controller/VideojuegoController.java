package com.catalogo.videojuegos.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController {

private static final List<String> TITULOS = List.of(
    "Cuphead","Fortnite", "Among us", "Left for Dead 2", "Street Figther 4 Ultra",
    "Sonic Mania", "Grand the auto VI","Minecraft", "Mortal Kombat", "Hollow Knight", "Fc 27", "Peak",
    "Assasing Cread","God of war","The Last of Us","Gear of War", "Outlast", "Roblox", "Far Cry", "Human fly flat",
    "Red Dead Redemption 2", "Elden Ring", "Hades", "Uncharted", "The Legend of Zelda", "Super Mario", "Pokemon", 
    "DOOM", "Dark Souls", "Devil May Cry"
);


@GetMapping
public String catalogo(@RequestParam(defaultValue="")String buscar,
                       @RequestParam(defaultValue="0")int pagina, 
                       @RequestParam(required=false)Boolean disponibles, Model modelo){
    
    List <String> encontrados = TITULOS.stream()
    .filter(t -> t.toLowerCase().contains(buscar.toLowerCase())).toList();

    modelo.addAttribute("titulos", encontrados);
    modelo.addAttribute("buscar", buscar);
    modelo.addAttribute("pagina", pagina);
    modelo.addAttribute("disponibles", disponibles);

    return "catalogo"; //templates/catalogo.html
}

@GetMapping("/nueva")
@ResponseBody
public String formularioNuevo(){
    return "aqui ira el formulario de alta";
}

@GetMapping("/{id}")
@ResponseBody
public String ficha(@PathVariable Long id){
    return "aqui ira la ficha del videojuego " + id;
}

}

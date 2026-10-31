package com.catalogo.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.service.NoEncontradoException;
import com.catalogo.videojuegos.service.ReglaNegocioException;
import com.catalogo.videojuegos.service.VideojuegoService;

import jakarta.validation.Valid;

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

@PostMapping 
public String crear(@Valid @ModelAttribute ("videojuego") Videojuego videojuego, BindingResult errores, RedirectAttributes flash){

    if (errores.hasErrors()){
        return "videojuegos/nuevo";
    }
    try {
        servicio.crear(videojuego);
    } catch (ReglaNegocioException e) {
        errores.rejectValue("nombre", "duplicado",e.getMessage());   
        return "videojuegos/nuevo";     
    }
    flash.addFlashAttribute("aviso","Videojuego añadido");
    return "redirect:/videojuegos";

}

@GetMapping("/{id}/editar")
public String formularioEditar(@PathVariable Long id, Model modelo) {
    Videojuego videojuego = servicio.buscar(id)
            .orElseThrow(() -> new NoEncontradoException("No existe el videojuego " + id));
    modelo.addAttribute("videojuego", videojuego);
    return "videojuegos/nuevo";
}

@PostMapping("/{id}")
public String editar(@PathVariable Long id, @Valid @ModelAttribute("videojuego") Videojuego videojuego,
                     BindingResult errores,
                     RedirectAttributes flash) {

    if (errores.hasErrors()) {
        return "videojuegos/nuevo";
    }
    try {
        servicio.editar(id, videojuego);      
    } catch (ReglaNegocioException e) {
        errores.rejectValue("nombre", "duplicado", e.getMessage());
        return "videojuegos/nuevo";
    }
    flash.addFlashAttribute("aviso", "Cambios guardados");
    return "redirect:/videojuegos/ficha/" + id;


}

}

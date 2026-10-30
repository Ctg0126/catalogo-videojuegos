package com.catalogo.videojuegos.controller.api;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.videojuegos.controller.dto.VideojuegoDTO;
import com.catalogo.videojuegos.controller.dto.VideojuegoEntrada;
import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.service.ReglaNegocioException;
import com.catalogo.videojuegos.service.VideojuegoService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/api/libros")
public class VideojuegoRestController {

    private final VideojuegoService servicio;

    public VideojuegoRestController(VideojuegoService servicio){
        this.servicio = servicio;
    }

@GetMapping 
public List<VideojuegoDTO> listar(@RequestParam (defaultValue = "")String buscar){
    return servicio.buscarPorNombre(buscar).stream().map(VideojuegoDTO::de).toList();
}

@GetMapping ("/{id}")
public ResponseEntity<VideojuegoDTO> uno(@PathVariable Long id){
    return servicio.buscar(id).map(VideojuegoDTO::de).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping 
public  ResponseEntity<VideojuegoDTO> crear(@RequestBody VideojuegoEntrada entrada){
    Videojuego creado = servicio.crear(new Videojuego(null, entrada.nombre(), entrada.genero(), entrada.plataforma(), entrada.precio(), entrada.imagen()));
    return ResponseEntity.created(URI.create("/api/Videojuegos"+ creado.getId())).body(VideojuegoDTO.de(creado));
}

@PutMapping("/{id}")
public VideojuegoDTO editar(@PathVariable Long id, @RequestBody VideojuegoEntrada entrada) {
    Videojuego actualizado = servicio.editar(id, new Videojuego(id, entrada.nombre(), entrada.genero(), entrada.plataforma(), entrada.precio(), entrada.imagen()));
    return VideojuegoDTO.de(actualizado);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> borrar(@PathVariable Long id){
    servicio.borrar(id);
    return ResponseEntity.noContent().build();
}

@ExceptionHandler(ReglaNegocioException.class) 
@ResponseStatus (HttpStatus.CONFLICT)
public Map<String, String> reglaRota(ReglaNegocioException e){
     return Map.of("error", e.getMessage());    
}
}

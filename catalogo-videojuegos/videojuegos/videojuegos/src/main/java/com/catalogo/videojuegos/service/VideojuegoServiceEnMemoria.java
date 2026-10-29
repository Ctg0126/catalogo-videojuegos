package com.catalogo.videojuegos.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.catalogo.videojuegos.model.Videojuego;

@Service 
public class VideojuegoServiceEnMemoria implements VideojuegoService{

    private final Map<Long, Videojuego> videojuegos = new LinkedHashMap<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

public VideojuegoServiceEnMemoria(){

    crear(new Videojuego(null, "Cuphead", "Acción, plataformas", "pc", 40000, null));
    crear(new Videojuego(null, "Fortnite", "Battle royale", "pc", 0, null));
    crear(new Videojuego(null, "Among Us", "Social, estrategia", "pc, móvil, consolas", 15000, null));
    crear(new Videojuego(null, "Left 4 Dead 2", "Acción, supervivencia", "pc, xbox 360", 20000, null));
    crear(new Videojuego(null, "Ultra Street Fighter IV", "Lucha", "pc, ps3, xbox 360", 40000, null));
    crear(new Videojuego(null, "Sonic Mania", "Plataformas", "pc, ps4, xbox one, switch", 35000, null));
    crear(new Videojuego(null, "Grand Theft Auto VI", "Acción, mundo abierto", "ps5, xbox series x/s", 320000, null));
    crear(new Videojuego(null, "Minecraft", "Sandbox, supervivencia", "pc, ps, xbox, switch, móvil", 120000, null));
    crear(new Videojuego(null, "Mortal Kombat 11", "Lucha", "pc, ps4, ps5, xbox, switch", 100000, null));
    crear(new Videojuego(null, "Hollow Knight", "Metroidvania, aventura", "pc, ps4, xbox, switch", 30000, null));
    crear(new Videojuego(null, "EA Sports FC 27", "Deportes, fútbol", "pc, ps, xbox, switch", 300000, null));
    crear(new Videojuego(null, "PEAK", "Aventura, cooperativo", "pc", 25000, null));
    crear(new Videojuego(null, "Assassin's Creed Valhalla", "Acción, aventura", "pc, ps4, ps5, xbox", 100000, null));
    crear(new Videojuego(null, "God of War", "Acción, aventura", "pc, ps4", 80000, null));
    crear(new Videojuego(null, "The Last of Us Part I", "Acción, supervivencia", "pc, ps5", 200000, null));
    crear(new Videojuego(null, "Gears of War 5", "Acción, disparos", "pc, xbox", 100000, null));
    crear(new Videojuego(null, "Outlast", "Terror, supervivencia", "pc, ps, xbox, switch", 35000, null));
    crear(new Videojuego(null, "Roblox", "Sandbox, varios géneros", "pc, móvil, xbox, ps", 0, null));
    crear(new Videojuego(null, "Far Cry 5", "Acción, mundo abierto", "pc, ps4, xbox one", 80000, null));
    crear(new Videojuego(null, "Human: Fall Flat", "Plataformas, puzles", "pc, ps, xbox, switch, móvil", 40000, null));
    crear(new Videojuego(null, "Red Dead Redemption 2", "Acción, mundo abierto", "pc, ps4, xbox one", 150000, null));
    crear(new Videojuego(null, "Elden Ring", "RPG, acción", "pc, ps4, ps5, xbox", 220000, null));
    crear(new Videojuego(null, "Hades", "Roguelike, acción", "pc, ps, xbox, switch", 45000, null));
    crear(new Videojuego(null, "Uncharted 4", "Acción, aventura", "ps4, pc", 100000, null));
    crear(new Videojuego(null, "The Legend of Zelda: Breath of the Wild", "Aventura, mundo abierto", "switch, wii u", 200000, null));
    crear(new Videojuego(null, "Super Mario Odyssey", "Plataformas, aventura", "switch", 200000, null));
    crear(new Videojuego(null, "Pokémon Escarlata", "RPG, aventura", "switch", 200000, null));
    crear(new Videojuego(null, "DOOM", "Acción, disparos", "pc, ps, xbox, switch", 50000, null));
    crear(new Videojuego(null, "Dark Souls III", "RPG, acción", "pc, ps4, xbox one", 120000, null));
    crear(new Videojuego(null, "Devil May Cry 5", "Acción, hack and slash", "pc, ps4, ps5, xbox", 100000, null));
   
}

@Override 
public List<Videojuego> listar(){
    return new ArrayList<>(videojuegos.values());
}

@Override 
public List<Videojuego> buscarPorNombre(String texto){
    if (texto == null || texto.isBlank()){
        return listar();
    }
    String aguja = texto.toLowerCase();

   return videojuegos.values().stream()
            .filter(v -> v.getNombre() != null
                    && v.getNombre().toLowerCase().contains(aguja))
            .toList();
}

@Override 
public Optional<Videojuego> buscar(Long id){
    return  Optional.ofNullable(videojuegos.get(id));
}

@Override 
public Videojuego crear(Videojuego videojuego){
    validar(videojuego);
    videojuego.setId(siguienteId.getAndIncrement());
    videojuegos.put(videojuego.getId(), videojuego);
    return videojuego;
}

@Override 
public Videojuego editar (Long id, Videojuego datos) {
    Videojuego videojuego = buscar(id).orElseThrow(() -> new NoEncontradoException("no se encuentra el Videojuego" + id));
    
    validar(datos);

    videojuego.setNombre(datos.getNombre());
    videojuego.setPlataforma(datos.getPlataforma());
    videojuego.setPrecio(datos.getPrecio()); 
    return videojuego;
}

@Override 
public void borrar(Long id){
    if (videojuegos.remove(id)== null){
        throw new NoEncontradoException("No existe el videojuego" + id);
    }
}

private void validar (Videojuego videojuego){
    if (videojuego.getNombre()== null || videojuego.getNombre().isBlank()){
        throw new ReglaNegocioException("El nombre es obligatorio");
    }

}

}

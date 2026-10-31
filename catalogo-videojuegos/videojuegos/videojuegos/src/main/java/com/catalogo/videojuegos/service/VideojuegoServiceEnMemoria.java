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

    crear(new Videojuego(null, "Cuphead", "Acción, plataformas", "pc,Xbox, PlayStation, Switch", 40000, "/img/cuphead-portada.jpg"));
    crear(new Videojuego(null, "Fortnite", "Battle royale", "pc", 0, "/img/fortnite-portada.jpg"));
    crear(new Videojuego(null, "Among Us", "Social, estrategia", "pc, móvil, consolas", 15000, "/img/amongus-portada.jpg"));
    crear(new Videojuego(null, "Left 4 Dead 2", "Acción, supervivencia", "pc, xbox 360", 20000, "/img/left-portada.jpg"));
    crear(new Videojuego(null, "Ultra Street Fighter IV", "Lucha", "pc, ps3, xbox 360", 40000, "/img/streetFighter-portada.jpg"));
    crear(new Videojuego(null, "Sonic Mania", "Plataformas", "pc, ps4, xbox one, switch", 35000, "/img/sonic-portada.jpg"));
    crear(new Videojuego(null, "Grand Theft Auto VI", "Acción, mundo abierto", "ps5, xbox series x/s", 320000, "/img/gta-portada.jpg"));
    crear(new Videojuego(null, "Minecraft", "Sandbox, supervivencia", "pc, ps, xbox, switch, móvil", 120000, "/img/minecraft-portada.jpg"));
    crear(new Videojuego(null, "Mortal Kombat 11", "Lucha", "pc, ps4, ps5, xbox, switch", 100000, "/img/mortalkombat-portada.jpg"));
    crear(new Videojuego(null, "Hollow Knight", "Metroidvania, aventura", "pc, ps4, xbox, switch", 30000, "/img/hollow-portada.jpg"));
    crear(new Videojuego(null, "EA Sports FC 27", "Deportes, fútbol", "pc, ps, xbox, switch", 300000, "/img/fc-portada.jpg"));
    crear(new Videojuego(null, "PEAK", "Aventura, cooperativo", "pc", 25000, "/img/peak-portada.jpg"));
    crear(new Videojuego(null, "Assassin's Creed Valhalla", "Acción, aventura", "pc, ps4, ps5, xbox", 100000, "/img/assasing-portada.jpg"));
    crear(new Videojuego(null, "God of War", "Acción, aventura", "pc, ps4", 80000, "/img/godofwar-portada.jpg"));
    crear(new Videojuego(null, "The Last of Us Part I", "Acción, supervivencia", "pc, ps5", 200000, "/img/thelastofus-portada.jpg"));
    crear(new Videojuego(null, "Gears of War 5", "Acción, disparos", "pc, xbox", 100000, "/img/gears-portada.jpg"));
    crear(new Videojuego(null, "Outlast", "Terror, supervivencia", "pc, ps, xbox, switch", 35000, "/img/outlast-portada.jpg"));
    crear(new Videojuego(null, "Roblox", "Sandbox, varios géneros", "pc, móvil, xbox, ps", 0, "/img/roblox-portada.jpg"));
    crear(new Videojuego(null, "Far Cry 5", "Acción, mundo abierto", "pc, ps4, xbox one", 80000, "/img/farcry-portada.jpg"));
    crear(new Videojuego(null, "Human: Fall Flat", "Plataformas, puzles", "pc, ps, xbox, switch, móvil", 40000, "/img/human-portada.jpg"));
    crear(new Videojuego(null, "Red Dead Redemption 2", "Acción, mundo abierto", "pc, ps4, xbox one", 150000, "/img/reddead-portada.jpg"));
    crear(new Videojuego(null, "Elden Ring", "RPG, acción", "pc, ps4, ps5, xbox", 220000, "/img/eldenring-portada.jpg"));
    crear(new Videojuego(null, "Hades", "Roguelike, acción", "pc, ps, xbox, switch", 45000, "/img/hades-portada.jpg"));
    crear(new Videojuego(null, "Uncharted 4", "Acción, aventura", "ps4, pc", 100000, "/img/uncharted-portada.jpg"));
    crear(new Videojuego(null, "The Legend of Zelda: Breath of the Wild", "Aventura, mundo abierto", "switch, wii u", 200000, "/img/zelda-portada.jpg"));
    crear(new Videojuego(null, "Super Mario Odyssey", "Plataformas, aventura", "switch", 200000, "/img/mario-portada.jpg"));
    crear(new Videojuego(null, "Pokémon Escarlata", "RPG, aventura", "switch", 200000, "/img/pokemon-portada.jpg"));
    crear(new Videojuego(null, "DOOM", "Acción, disparos", "pc, ps, xbox, switch", 50000, "/img/doom-portada.jpg"));
    crear(new Videojuego(null, "Dark Souls III", "RPG, acción", "pc, ps4, xbox one", 120000, "/img/darksouls-portada.jpg"));
    crear(new Videojuego(null, "Devil May Cry 5", "Acción, hack and slash", "pc, ps4, ps5, xbox", 100000, "/img/devilmaycry-portada.jpg"));
   
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
    videojuego.setGenero(datos.getGenero());
    videojuego.setPlataforma(datos.getPlataforma());
    videojuego.setPrecio(datos.getPrecio()); 
    videojuego.setImagen(datos.getImagen());
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

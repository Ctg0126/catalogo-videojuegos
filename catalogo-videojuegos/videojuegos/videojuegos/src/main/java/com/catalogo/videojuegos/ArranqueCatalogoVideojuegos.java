package com.catalogo.videojuegos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.repository.VideojuegoRepository;

@Component
public class ArranqueCatalogoVideojuegos implements CommandLineRunner {

    private final VideojuegoRepository repo;

    public ArranqueCatalogoVideojuegos(VideojuegoRepository repo){
        this.repo = repo;
    }


    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.saveAll(List.of(
            new Videojuego("Cuphead", "Acción, plataformas", "pc,Xbox, PlayStation, Switch", 40000.0, "/img/cuphead-portada.jpg"),
            new Videojuego("Fortnite", "Battle royale", "pc", 0.0, "/img/fortnite-portada.jpg"),
            new Videojuego("Among Us", "Social, estrategia", "pc, móvil, consolas", 15000.0, "/img/amongus-portada.jpg"),
            new Videojuego("Left 4 Dead 2", "Acción, supervivencia", "pc, xbox 360", 20000.0, "/img/left-portada.jpg"),
            new Videojuego("Ultra Street Fighter IV", "Lucha", "pc, ps3, xbox 360", 40000.0, "/img/streetFighter-portada.jpg"),
            new Videojuego("Sonic Mania", "Plataformas", "pc, ps4, xbox one, switch", 35000.0, "/img/sonic-portada.jpg"),
            new Videojuego("Grand Theft Auto VI", "Acción, mundo abierto", "ps5, xbox series x/s", 320000.0, "/img/gta-portada.jpg"),
            new Videojuego("Minecraft", "Sandbox, supervivencia", "pc, ps, xbox, switch, móvil", 120000.0, "/img/minecraft-portada.jpg"),
            new Videojuego("Mortal Kombat 11", "Lucha", "pc, ps4, ps5, xbox, switch", 100000.0, "/img/mortalkombat-portada.jpg"),
            new Videojuego("Hollow Knight", "Metroidvania, aventura", "pc, ps4, xbox, switch", 30000.0, "/img/hollow-portada.jpg"),
            new Videojuego("EA Sports FC 27", "Deportes, fútbol", "pc, ps, xbox, switch", 300000.0, "/img/fc-portada.jpg"),
            new Videojuego("PEAK", "Aventura, cooperativo", "pc", 25000.0, "/img/peak-portada.jpg"),
            new Videojuego("Assassin's Creed Valhalla", "Acción, aventura", "pc, ps4, ps5, xbox", 100000.0, "/img/assasing-portada.jpg"),
            new Videojuego("God of War", "Acción, aventura", "pc, ps4", 80000.0, "/img/godofwar-portada.jpg"),
            new Videojuego("The Last of Us Part I", "Acción, supervivencia", "pc, ps5", 200000.0, "/img/thelastofus-portada.jpg"),
            new Videojuego("Gears of War 5", "Acción, disparos", "pc, xbox", 100000.0, "/img/gears-portada.jpg"),
            new Videojuego("Outlast", "Terror, supervivencia", "pc, ps, xbox, switch", 35000.0, "/img/outlast-portada.jpg"),
            new Videojuego("Roblox", "Sandbox, varios géneros", "pc, móvil, xbox, ps", 0.0, "/img/roblox-portada.jpg"),
            new Videojuego("Far Cry 5", "Acción, mundo abierto", "pc, ps4, xbox one", 80000.0, "/img/farcry-portada.jpg"),
            new Videojuego("Human: Fall Flat", "Plataformas, puzles", "pc, ps, xbox, switch, móvil", 40000.0, "/img/human-portada.jpg"),
            new Videojuego("Red Dead Redemption 2", "Acción, mundo abierto", "pc, ps4, xbox one", 150000.0, "/img/reddead-portada.jpg"),
            new Videojuego("Elden Ring", "RPG, acción", "pc, ps4, ps5, xbox", 220000.0, "/img/eldenring-portada.jpg"),
            new Videojuego("Hades", "Roguelike, acción", "pc, ps, xbox, switch", 45000.0, "/img/hades-portada.jpg"),
            new Videojuego("Uncharted 4", "Acción, aventura", "ps4, pc", 100000.0, "/img/uncharted-portada.jpg"),
            new Videojuego("The Legend of Zelda: Breath of the Wild", "Aventura, mundo abierto", "switch, wii u", 200000.0, "/img/zelda-portada.jpg"),
            new Videojuego("Super Mario Odyssey", "Plataformas, aventura", "switch", 200000.0, "/img/mario-portada.jpg"),
            new Videojuego("Pokémon Escarlata", "RPG, aventura", "switch", 200000.0, "/img/pokemon-portada.jpg"),
            new Videojuego("DOOM", "Acción, disparos", "pc, ps, xbox, switch", 50000.0, "/img/doom-portada.jpg"),
            new Videojuego("Dark Souls III", "RPG, acción", "pc, ps4, xbox one", 120000.0, "/img/darksouls-portada.jpg"),
            new Videojuego("Devil May Cry 5", "Acción, hack and slash", "pc, ps4, ps5, xbox", 100000.0, "/img/devilmaycry-portada.jpg")
        ));
        }

        System.out.println("Videojuegos cargados: " + repo.count());

        repo.findAll(Sort.by("nombre"))
            .forEach(v -> System.out.println("  " + v.getNombre()));


             System.out.println("=== Catálogo de Videojuegos listo ===");
    }
    
}
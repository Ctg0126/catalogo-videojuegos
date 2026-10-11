package com.catalogo.videojuegos.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class CatalogoDemo implements Catalogo {
    
    @Override 
    public List<String> TITULOS(){
        return List.of(
            "Cuphead","Fortnite", "Among us", "Left for Dead 2", "Street Figther 4 Ultra",
    "Sonic Mania", "Grand the auto VI","Minecraft", "Mortal Kombat", "Hollow Knight", "Fc 27", "Peak",
    "Assasing Cread","God of war","The Last of Us","Gear of War", "Outlast", "Roblox", "Far Cry", "Human fly flat",
    "Red Dead Redemption 2", "Elden Ring", "Hades", "Uncharted", "The Legend of Zelda", "Super Mario", "Pokemon", 
    "DOOM", "Dark Souls", "Devil May Cry"
        );
    }
}

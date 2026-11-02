package com.catalogo.videojuegos.config;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class WebConfig implements WebMvcConfigurer {

    private final String carpeta;

  public WebConfig(@Value("${gamecatalog.imagenes}") String carpeta) {
        this.carpeta = carpeta;
    }

    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registro){
        String ruta = Path.of(carpeta).toAbsolutePath().normalize().toUri().toString();
        registro.addResourceHandler("/imagenes-videojuegos/**").addResourceLocations(ruta);
    }

}

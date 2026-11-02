package com.catalogo.videojuegos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service 
public class StorageService {

    private static final Set<String> TIPOS = Set.of("image/jpeg", "image/png", "image/webp");
    private final Path carpeta;

    public StorageService(@Value("${gamecatalog.imagenes}") String ruta) throws IOException {
        this.carpeta = Path.of(ruta).toAbsolutePath().normalize();
        Files.createDirectories(this.carpeta);
    }

    public String guardarImagen(Long idVideojuego, MultipartFile archivo){
        if (archivo == null || archivo.isEmpty()){
            return null;
        }
        if (!TIPOS.contains(archivo.getContentType())){
            throw new ReglaNegocioException("La imagen debe ser JPG, PNG o WEBP");
        }

        String nombre = "videojuego-" + idVideojuego + extension(archivo.getContentType());
        Path destino = carpeta.resolve(nombre);

        try (var in = archivo.getInputStream()) {
            Files.copy(in, destino, StandardCopyOption.REPLACE_EXISTING );
        } catch (IOException e) {
            throw new ReglaNegocioException("No se pudo guardar la imagen");
        }
        return nombre;
    }

    private String extension(String tipo){
        return switch (tipo){
            case "image/png" -> ".png";
            case "image/webp" -> ".webp";
            default -> ".jpg";
        };
    }

}

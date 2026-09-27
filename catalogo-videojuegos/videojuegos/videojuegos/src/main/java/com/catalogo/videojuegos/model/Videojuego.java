package com.catalogo.videojuegos.model;

public class Videojuego {

    private String nombre;
    private String genero;
    private String plataforma;
    private double precio;
    private String imagen;

    public Videojuego(String nombre, String genero, String plataforma, double precio, String imagen) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }
}

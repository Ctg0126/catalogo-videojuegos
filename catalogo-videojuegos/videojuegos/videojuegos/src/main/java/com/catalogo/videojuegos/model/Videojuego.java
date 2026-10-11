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

    public String getNombre() { return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getGenero() { return genero;}
    public void setGenero(String genero) {this.genero = genero;}

    public String getPlataforma() { return plataforma;}
    public void setPlataforma(String plataforma) {this.plataforma = plataforma;}

    public double getPrecio() { return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    public String getImagen() { return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}

}

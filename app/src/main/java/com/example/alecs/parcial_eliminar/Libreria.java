package com.example.alecs.parcial_eliminar;

/**
 * Created by Alecs on 16/06/2016.
 */
public class Libreria {
    private String nombre;
    private String autor;
    private String editorial;
    private String tipo;

    public Libreria(){
        super();
    }

    public Libreria(String nombre, String autor, String editorial, String tipo) {
        this.nombre=nombre;
        this.autor=autor;
        this.editorial=editorial;
        this.tipo=tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

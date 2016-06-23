package com.example.alecs.parcial_eliminar;

/**
 * Created by Alecs on 18/06/2016.
 */
public interface LibreriasInterface {
    Libreria elemento(int id);
    void insertar(Libreria libros);
    int nuevo();
    boolean borrar(int id);
    boolean borrar(String nombreLibro);
    int tamanio();
    void modificar(int id, Libreria libro);
}

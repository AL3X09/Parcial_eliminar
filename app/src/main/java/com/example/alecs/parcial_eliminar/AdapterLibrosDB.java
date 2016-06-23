package com.example.alecs.parcial_eliminar;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Alecs on 18/06/2016.
 */
public class AdapterLibrosDB extends AdapterLibros {
    protected Cursor cursor;


    public AdapterLibrosDB( Context context,LibreriasInterface libroi, Cursor cursor) {
        super(libroi, context);
        this.cursor=cursor;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public Libreria lugarPosicion(int posicion) {
        cursor.moveToPosition(posicion);
        return LibreriaDB.extraeLugar(cursor);
    }

    public int idPosicion(int posicion) {
        cursor.moveToPosition(posicion);
        return cursor.getInt(0);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libreria libros = lugarPosicion(position);
        personalizaVista(holder, libros);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }


}

package com.example.alecs.parcial_eliminar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alecs on 16/06/2016.
 */
public class LibreriaDB extends SQLiteOpenHelper implements LibreriasInterface {
    private static final int BASE_VERSION = 1;
    private static final String BASE_NAME = "libreria.db";
    private static final String BASE_TABLE = "libro";
    private static final String COLUM_NOMBRE = "nombre";
    private static final String COLUM_AUTOR = "autor";
    private static final String COLUM_EDITORIAL = "editorial";
    private static final String COLUM_TIPO = "tipo";


    public LibreriaDB(Context context) {
        super(context, BASE_NAME, null, BASE_VERSION);
    }



    /*
        public LibreriaDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + BASE_TABLE + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUM_NOMBRE + " TEXT, " + COLUM_AUTOR + " TEXT, " +
                COLUM_EDITORIAL + " TEXT, "+COLUM_TIPO+" TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST " + BASE_TABLE;
        db.execSQL(query);
        onCreate(db);

    }

    @Override
    public Libreria elemento(int id) {
        Libreria libro=null;
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM "+BASE_TABLE+" WHERE _id ="+id,null);
        if (cursor.moveToNext()){
            libro=extraeLugar(cursor);
        }
        cursor.close();
        bd.close();
        return libro;
    }

    @Override
    public void insertar(Libreria libros){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores =new ContentValues();
        valores.put(COLUM_NOMBRE,libros.getNombre());
        valores.put(COLUM_AUTOR,libros.getAutor());
        valores.put(COLUM_EDITORIAL,libros.getEditorial());
        valores.put(COLUM_TIPO,libros.getTipo());
        db.insert(BASE_TABLE,null,valores);
        db.close();

    }

    @Override
    public int nuevo() {
        return 0;
    }

    @Override
    public boolean borrar(int id) {
        return false;
    }


    @Override
    public boolean borrar(String nombreLibro){
        SQLiteDatabase db = getWritableDatabase();
        if (nombreLibro!=" "){
        db.delete(BASE_TABLE,COLUM_NOMBRE+" = ? ",new String[]{nombreLibro.toString()});
        db.close();
        return true;
        }
        return false;
    }

    @Override
    public int tamanio() {
        return 0;
    }

    @Override
    public void modificar(int id, Libreria libro){
        SQLiteDatabase db = getWritableDatabase();
        //String nombre=libro.getNombre();
        //ContentValues valores =new ContentValues();
        //valores.put(COLUM_NOMBRE,libro.getNombre());
        //db.update(BASE_TABLE,valores,COLUM_NOMBRE+"= '"+nombre+"'",null);

        db.execSQL("UPDATE "+BASE_TABLE+" SET "+COLUM_NOMBRE+" = '"+libro.getNombre()+
                "',"+COLUM_AUTOR+" = '"+libro.getAutor()+
                "',"+COLUM_EDITORIAL+" = '"+libro.getEditorial()+
                "',"+COLUM_TIPO+" = '"+libro.getTipo()+
                "' WHERE _id = "+id);
        db.close();
    }

//este metodo crea un  lugar con la posicion actual de un cursor
    public static Libreria extraeLugar(Cursor cursor) {
        Libreria libro = new Libreria();
        libro.setNombre(cursor.getString(1));
        libro.setAutor(cursor.getString(2));
        libro.setEditorial(cursor.getString(3));
        libro.setTipo(cursor.getString(4));
        return libro;
    }
//este nos retorna el cursor q contiene los datos de la tabla
    public Cursor extraerCursor(){
        String consulta="SELECT * FROM "+BASE_TABLE;
        SQLiteDatabase bd =getReadableDatabase();
        return bd.rawQuery(consulta,null);
    }


}

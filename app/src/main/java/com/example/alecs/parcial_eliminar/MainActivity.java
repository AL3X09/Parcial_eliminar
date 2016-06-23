package com.example.alecs.parcial_eliminar;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static EditText libro,autor,editorial,tipo;
    public static LibreriaDB db;
    public static AdapterLibros adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libro=(EditText) findViewById(R.id.txt_nomLibro);
        autor=(EditText)findViewById(R.id.txt_autor);
        editorial=(EditText)findViewById(R.id.txt_editorial);
        tipo=(EditText)findViewById(R.id.txt_tiLectura);
        db = new LibreriaDB(this);
        adaptador = new AdapterLibrosDB(this,db,db.extraerCursor());
    }

    public void clickInsertar(View view){
        Libreria libros = new Libreria(libro.getText().toString(),autor.getText().toString(),editorial.getText().toString(),tipo.getText().toString());
        db.insertar(libros);
        limpiarCampos();
    }

    private void limpiarCampos() {
        libro.setText("");
        autor.setText("");
        editorial.setText("");
        tipo.setText("");
    }

    public void onClickEliminar(View view){
        Intent i =new Intent(this,BorrarActivity.class);
        startActivity(i);
    }
    public void onClickListar(View view){
        Intent i =new Intent(this,ListarActivity.class);
        startActivity(i);
    }

}

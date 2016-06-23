package com.example.alecs.parcial_eliminar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListarActivity extends AppCompatActivity {
    public static LibreriaDB db;
    private RecyclerView recyclerView;
    public static AdapterLibros adaptador;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        db = new LibreriaDB(this);
        //se busca el recicler por su id
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        adaptador = new AdapterLibrosDB(this,db,db.extraerCursor());
        //se crea un nuevo layout manager de tipo LinearLayoutManager y lo asignamos al recicler view
        recyclerView.setAdapter(adaptador);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}

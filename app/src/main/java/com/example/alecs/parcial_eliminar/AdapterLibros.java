package com.example.alecs.parcial_eliminar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

/**
 * Created by Alecs on 18/06/2016.
 */
public class AdapterLibros extends RecyclerView.Adapter<AdapterLibros.ViewHolder>{
    protected LibreriasInterface libroi; //libros a mostrar
    protected LayoutInflater infaldor; //crea layaouts a partir de xml
    protected Context context; //contexto para el inflador

    public AdapterLibros(LibreriasInterface libroi, Context context) {
        this.libroi = libroi;
        infaldor = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }
    //creamos el viewholder con los elementos a eliminar
    public static  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView listLibro,listAutor;

        public ViewHolder(View itemView) {
            super(itemView);
            listLibro=(TextView)itemView.findViewById(R.id.txt_listlibro);
            listAutor=(TextView)itemView.findViewById(R.id.txt_listAutor);
        }

    }
    //creamos un viwholder con la vista de un elemento sin personalizar
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflamos la vista
        View v=infaldor.inflate(R.layout.elemento_lista,parent,false);
        return new ViewHolder(v);
    }

      //usando de base el viewholder se personaliza
    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Libreria libro= libroi.elemento(posicion);
        personalizaVista(holder,libro);
        }
//personalizamos el view holder a partir de un lugar
    public void personalizaVista(ViewHolder holder, Libreria libro) {

        holder.listLibro.setText(libro.getNombre());
        holder.listAutor.setText(libro.getAutor());
    }


    @Override
    public int getItemCount() {
        //libroi.tamanyo();
        return 0;
    }
}

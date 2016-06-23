package com.example.alecs.parcial_eliminar;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BorrarActivity extends AppCompatActivity {
    private static EditText nombreB;
    private static LibreriaDB base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        nombreB=(EditText)findViewById(R.id.txt_borrar);
        base =new LibreriaDB(this);
    }
    public void onClickBorrar(View view){
        //Libreria libro =new Libreria(nombreB.getText().toString(),null,null,null);
        if (nombreB.getText().length()== 0) {
            mensageErrorVacio();
        }
        else {
            boolean opera=base.borrar(nombreB.getText().toString());
                if (opera==true){
                    limpiarCampos();
                    mensage();
                }else{
                    limpiarCampos();
                    mensageErrorBorrar();
                }
        }

    }

    private void mensageErrorBorrar() {
        Context context = getApplicationContext();
        CharSequence text = "Libro No se pudo Borrar!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void mensageErrorVacio() {
        Context context = getApplicationContext();
        CharSequence text = "Ingrese un valor!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void limpiarCampos(){
        nombreB.setText("");
    }

    public void mensage(){
        Context context = getApplicationContext();
        CharSequence text = "Libro Borrado!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}

package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Imagenes extends AppCompatActivity {

    /**
     *
     */


    public int imagenNum;
    public String d1;
    public String d2;
    public String d3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        recibirDatos();
        cambiarImagen();
        cambiarTextos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        imagenNum = Integer.parseInt(extras.getString("dato00"));
        d1 = extras.getString("dato01");
        d2 = extras.getString("dato02");
        d3 = extras.getString("dato03");
    }

    public void cambiarImagen(){
        ImageView imagen =(ImageView)findViewById(R.id.imagen);
        //imagen.setImageResource(imagenes[imagenNum]);
    }

    public void cambiarTextos(){

        TextView txtSaludo = (TextView)findViewById(R.id.textoSaludo);
        txtSaludo.setText("Hola" );

        TextView txtRecomendacion = (TextView)findViewById(R.id.textoRecomendacion);
        txtRecomendacion.setText(""+d2);

        TextView txtEjercicio = (TextView)findViewById(R.id.textoEjercicio);
        txtEjercicio.setText(""+d3);
    }




}

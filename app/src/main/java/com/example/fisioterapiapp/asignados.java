package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class asignados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignados);
    }
    //esto es un comentario de Jai Master.

    public void buttonRegresar(View view){
        Intent intent = new Intent(asignados.this, menuPrincipal.class);
        startActivity(intent);
    }
}

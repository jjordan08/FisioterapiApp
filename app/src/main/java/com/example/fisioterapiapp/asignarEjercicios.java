package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class asignarEjercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_ejercicios);
    }

    public void buttonAsignar(View view){
        Intent intent = new Intent(asignarEjercicios.this, datosPaciente.class);
        Toast.makeText(this, "Los ejercicios fueron asignados exitosamente", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void buttonVerRegresar(View view){
        Intent intent = new Intent(asignarEjercicios.this,datosPaciente.class);
        startActivity(intent);
    }
}

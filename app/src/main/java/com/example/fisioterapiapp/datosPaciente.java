
package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class datosPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_paciente);
    }

    public void buttonHistorial(View view){
        Intent intent = new Intent(datosPaciente.this, historial.class);
        intent.putExtra("dato00", "1");
        startActivity(intent);
    }

    public void buttonAsignarEjercicios(View view){
        Intent intent = new Intent(datosPaciente.this, asignarEjercicios.class);
        startActivity(intent);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(datosPaciente.this, inicioDoctor.class);
        startActivity(intent);
    }

}

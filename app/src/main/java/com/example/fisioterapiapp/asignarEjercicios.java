package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class asignarEjercicios extends AppCompatActivity {

    Spinner frecuencia1_1;
    Spinner frecuencia1_2;
    Spinner frecuencia1_3;
    Spinner frecuencia2_1;
    Spinner frecuencia2_2;
    Spinner frecuencia3_1;
    Spinner frecuencia3_2;
    Spinner frecuencia4_1;
    Spinner frecuencia4_2;
    Spinner frecuencia4_3;
    Spinner frecuencia4_4;
    Spinner frecuencia4_5;
    Spinner frecuencia5_1;
    Spinner frecuencia5_2;
    Spinner frecuencia5_3;
    Spinner frecuencia5_4;
    Spinner frecuencia5_5;
    Spinner frecuencia6_1;
    Spinner frecuencia6_2;
    Spinner frecuencia6_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_ejercicios);

        frecuencia1_1 = (Spinner)findViewById(R.id.spinnerEje1_1);
        frecuencia1_2 = (Spinner)findViewById(R.id.spinnerEje1_2);
        frecuencia2_1 = (Spinner)findViewById(R.id.spinnerEje2_1);
        frecuencia2_2 = (Spinner)findViewById(R.id.spinnerEje2_2);
        frecuencia3_1 = (Spinner)findViewById(R.id.spinnerEje3_1);
        frecuencia3_2 = (Spinner)findViewById(R.id.spinnerEje3_2);
        frecuencia4_1 = (Spinner)findViewById(R.id.spinnerEje4_1);
        frecuencia4_2 = (Spinner)findViewById(R.id.spinnerEje4_2);
        frecuencia4_3 = (Spinner)findViewById(R.id.spinnerEje4_3);
        frecuencia4_4 = (Spinner)findViewById(R.id.spinnerEje4_4);
        frecuencia4_5 = (Spinner)findViewById(R.id.spinnerEje4_5);
        frecuencia5_1 = (Spinner)findViewById(R.id.spinnerEje5_1);
        frecuencia5_2 = (Spinner)findViewById(R.id.spinnerEje5_2);
        frecuencia5_3 = (Spinner)findViewById(R.id.spinnerEje5_3);
        frecuencia5_4 = (Spinner)findViewById(R.id.spinnerEje5_4);
        frecuencia5_5 = (Spinner)findViewById(R.id.spinnerEje5_5);
        frecuencia6_1 = (Spinner)findViewById(R.id.spinnerEje6_1);
        frecuencia6_2 = (Spinner)findViewById(R.id.spinnerEje6_2);
        frecuencia6_3 = (Spinner)findViewById(R.id.spinnerEje6_3);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Frecuencia, android.R.layout.simple_spinner_item);
        frecuencia1_1.setAdapter(adapter);
        frecuencia1_2.setAdapter(adapter);
        frecuencia1_3.setAdapter(adapter);
        frecuencia2_2.setAdapter(adapter);
        frecuencia3_1.setAdapter(adapter);
        frecuencia3_2.setAdapter(adapter);
        frecuencia4_1.setAdapter(adapter);
        frecuencia4_2.setAdapter(adapter);
        frecuencia4_3.setAdapter(adapter);
        frecuencia4_4.setAdapter(adapter);
        frecuencia4_5.setAdapter(adapter);
        frecuencia5_1.setAdapter(adapter);
        frecuencia5_2.setAdapter(adapter);
        frecuencia5_3.setAdapter(adapter);
        frecuencia5_4.setAdapter(adapter);
        frecuencia5_5.setAdapter(adapter);
        frecuencia6_1.setAdapter(adapter);
        frecuencia6_2.setAdapter(adapter);
        frecuencia6_3.setAdapter(adapter);





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

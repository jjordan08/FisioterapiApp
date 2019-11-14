package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejercicios extends AppCompatActivity {

    public int num = 0;
    public String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        recibirDatos();
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonCabezaCuello(View view) {
        Intent intent = new Intent(Ejercicios.this, cabezaCuello.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonHombros(View view) {
        Intent intent = new Intent(Ejercicios.this, hombros.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonCodoAntebrazo(View view) {
        Intent intent = new Intent(Ejercicios.this, codoAntebrazo.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonManoMuneca(View view) {
        Intent intent = new Intent(Ejercicios.this, manoMuneca.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonTroncoCadera(View view) {
        Intent intent = new Intent(Ejercicios.this, troncoCadera.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonTobilloPies(View view) {
        Intent intent = new Intent(Ejercicios.this, tobilloPies.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonRegresar(View view) {

        if (num == 1) {
            Intent intent = new Intent(Ejercicios.this, inicioDoctor.class);
            startActivity(intent);
        } else if (num == 0){
            Intent intent = new Intent(Ejercicios.this, menuPrincipal.class);
            startActivity(intent);
        }
    }
}

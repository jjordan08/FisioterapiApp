package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
    }

    public void buttonCabezaCuello(View view){
        Intent intent = new Intent(Ejercicios.this,cabezaCuello.class);
        startActivity(intent);
    }

    public void buttonHombros(View view){
        Intent intent = new Intent(Ejercicios.this,hombros.class);
        startActivity(intent);
    }

    public void buttonCodoAntebrazo(View view){
        Intent intent = new Intent(Ejercicios.this,codoAntebrazo.class);
        startActivity(intent);
    }

    public void buttonManoMuneca(View view){
        Intent intent = new Intent(Ejercicios.this,manoMuneca.class);
        startActivity(intent);
    }

    public void buttonTroncoCadera(View view){
        Intent intent = new Intent(Ejercicios.this,troncoCadera.class);
        startActivity(intent);
    }

    public void buttonTobilloPies(View view){
        Intent intent = new Intent(Ejercicios.this,tobilloPies.class);
        startActivity(intent);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(Ejercicios.this,menuPrincipal.class);
        startActivity(intent);
    }
}

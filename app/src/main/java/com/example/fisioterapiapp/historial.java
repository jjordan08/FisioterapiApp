package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class historial extends AppCompatActivity {


    public int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        recibirDatos();
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
    }

    public void buttonRegresar(View view) {

        if (num == 1) {

            Intent intent = new Intent(historial.this, datosPaciente.class);
            startActivity(intent);
        }else if (num == 0){

            Intent intent = new Intent(historial.this, menuPrincipal.class);
            startActivity(intent);
        }
    }
}

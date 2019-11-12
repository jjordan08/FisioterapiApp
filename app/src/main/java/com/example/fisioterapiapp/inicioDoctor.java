package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class inicioDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_doctor);
    }

    public void buttonBuscar(View view){
        Intent intent = new Intent(inicioDoctor.this, datosPaciente.class);
        startActivity(intent);
    }

    public void buttonVerEjercicios(View view){
        Intent intent = new Intent(inicioDoctor.this,Ejercicios.class);
        startActivity(intent);
    }



    public void buttonSalir(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(inicioDoctor.this, logIn.class);
        startActivity(intent);
        Toast.makeText(this, "Ha cerrado sesión", Toast.LENGTH_SHORT).show();
    }
}

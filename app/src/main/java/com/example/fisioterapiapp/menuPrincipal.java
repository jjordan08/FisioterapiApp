package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class menuPrincipal extends AppCompatActivity {

    FirebaseAuth Salir;
    private FirebaseAuth.AuthStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void buttonEjerciciosAsignados(View view){
        Intent intent = new Intent(menuPrincipal.this, asignados.class);
        startActivity(intent);
    }

    public void buttonVerEjercicios(View view){
        Intent intent = new Intent(menuPrincipal.this,Ejercicios.class);
        intent.putExtra("dato00", "0");
        startActivity(intent);
    }

    public void buttonHistorial(View view){
        Intent intent = new Intent(menuPrincipal.this, historial.class);
        intent.putExtra("dato00", "0");
        startActivity(intent);
    }

    public void buttonSalir(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(menuPrincipal.this, login2.class);
        startActivity(intent);
        Toast.makeText(this, "Ha cerrado sesión", Toast.LENGTH_SHORT).show();
    }
}

package com.example.fisioterapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class menuPrincipal extends AppCompatActivity {


    public static final String user="names";
    TextView textUser;


    FirebaseAuth Salir;
    private FirebaseAuth.AuthStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        textUser = (TextView)findViewById(R.id.textView5);
        String user = getIntent().getStringExtra("names");
        textUser.setText("Hola  "+user+"\nSelecciona que deseas hacer:");
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
        Intent intent = new Intent(menuPrincipal.this, LogIn.class);
        startActivity(intent);
        Toast.makeText(this, "Ha cerrado sesión", Toast.LENGTH_SHORT).show();
    }
}

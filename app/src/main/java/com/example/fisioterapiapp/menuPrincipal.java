package com.example.fisioterapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class menuPrincipal extends AppCompatActivity {


    public static final String user="names";

    TextView textUser;
    DatabaseReference referencia;
    FirebaseAuth firebaseAuth;


    FirebaseAuth Salir;
    private FirebaseAuth.AuthStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        textUser = (TextView)findViewById(R.id.textView5);
        referencia = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        referencia.child("Paciente").child(id).child("nombre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String nombre = dataSnapshot.getValue().toString();
                    textUser.setText("Hola "+nombre+"\nSelecciona que deseas hacer:");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



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

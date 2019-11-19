package com.example.fisioterapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ejercicios extends AppCompatActivity {

    public static final String user="names";
    TextView textUser2;
    DatabaseReference referencia;
    FirebaseAuth firebaseAuth;

    public int num = 0;
    public String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        recibirDatos();

        textUser2 = (TextView)findViewById(R.id.textView4);
        referencia = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        referencia.child("Paciente").child(id).child("nombre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String nombre = dataSnapshot.getValue().toString();
                    textUser2.setText("Hola "+nombre+"\nSelecciona que ejercicios deseas realizar:");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

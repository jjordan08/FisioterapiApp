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

public class asignados extends AppCompatActivity {

    public static final String user="names";
    TextView textUser1;
    DatabaseReference referencia;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignados);

        textUser1 = (TextView)findViewById(R.id.textView9);
        referencia = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        referencia.child("Paciente").child(id).child("nombre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String nombre = dataSnapshot.getValue().toString();
                    textUser1.setText(""+nombre+"\nTu médico asignó los siguientrs ejercicios dos veces por día");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //esto es un comentario de Jai Master.

    public void buttonRegresar(View view){
        Intent intent = new Intent(asignados.this, menuPrincipal.class);
        startActivity(intent);
    }
}

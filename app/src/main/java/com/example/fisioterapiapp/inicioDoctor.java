package com.example.fisioterapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class inicioDoctor extends AppCompatActivity {

    TextView textDoctor;
    TextView txtCedula;
    String cedula;
    DatabaseReference referencia;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_doctor);

        textDoctor = (TextView) findViewById(R.id.textView22);
        txtCedula = (TextView) findViewById(R.id.editText4);
        cedula = txtCedula.toString();
        referencia = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        referencia.child("Medico").child(id).child("nombre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String nombre = dataSnapshot.getValue().toString();
                    textDoctor.setText("Hola "+nombre+"\npuedes buscar un paciente o ver los ejercicios disponibles.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }




    public void buttonBuscar(View view){

        if(cedula.isEmpty()) {
            Toast.makeText(this, "Digite la cedula del paciente", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(inicioDoctor.this, datosPaciente.class);
            intent.putExtra("dato00", cedula);
            startActivity(intent);
        }
    }

    public void buttonVerEjercicios(View view){
        Intent intent = new Intent(inicioDoctor.this,Ejercicios.class);
        intent.putExtra("dato00", "1");
        startActivity(intent);
    }



    public void buttonSalir(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(inicioDoctor.this, LogIn.class);
        startActivity(intent);
        Toast.makeText(this, "Ha cerrado sesión", Toast.LENGTH_SHORT).show();
    }
}

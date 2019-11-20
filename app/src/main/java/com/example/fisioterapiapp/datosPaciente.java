
package com.example.fisioterapiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class datosPaciente extends AppCompatActivity {

    TextView textDatosPaciente;
    DatabaseReference nombre;
    DatabaseReference apellido;
    DatabaseReference cedula;
    DatabaseReference edad;
    DatabaseReference sexo;
    FirebaseAuth firebaseAuth;
    public int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_paciente);


        textDatosPaciente = (TextView) findViewById(R.id.textView24);
        nombre = FirebaseDatabase.getInstance().getReference();
        apellido = FirebaseDatabase.getInstance().getReference();
        cedula = FirebaseDatabase.getInstance().getReference();
        edad = FirebaseDatabase.getInstance().getReference();
        sexo = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        nombre.child("Medico").child(id).child("nombre").addValueEventListener(new ValueEventListener(){

                @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String nombre = dataSnapshot.getValue().toString();
                    String apellido = dataSnapshot.getValue().toString();
                    String cedula = dataSnapshot.getValue().toString();
                    String edad = dataSnapshot.getValue().toString();
                    String sexo = dataSnapshot.getValue().toString();

                    textDatosPaciente.setText("nombre: "+nombre+"\nApellido: "+apellido+"\nCedula: "+cedula+"\nEdad: "+edad+"\nSexo: "+sexo);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void buttonHistorial(View view){
        Intent intent = new Intent(datosPaciente.this, historial.class);
        intent.putExtra("dato00", "1");
        startActivity(intent);
    }

    public void buttonAsignarEjercicios(View view){
        Intent intent = new Intent(datosPaciente.this, asignarEjercicios.class);
        startActivity(intent);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(datosPaciente.this, inicioDoctor.class);
        startActivity(intent);
    }

}

package com.example.fisioterapiapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LogIn extends AppCompatActivity implements View.OnClickListener {
    //defining view objects
    private EditText TextEmail;
    private EditText TextPassword;
    private TextView TipoUsuario;
    private Button btnRegistrar;
    private ProgressDialog progressDialog;
    public String paciente  =  "paciente";
    public String doctor =  "doctor";
    public String clave =  "admin";


    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;
    private DatabaseReference data;
    private DatabaseReference referencia;
    private DatabaseReference referencia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //inicializamos el objeto firebaseAuth

        firebaseAuth = FirebaseAuth.getInstance();

        data = FirebaseDatabase.getInstance().getReference();



        //Referenciamos los views
        TipoUsuario = (TextView) findViewById(R.id.textView22);
        TextEmail = (EditText) findViewById(R.id.editText2);
        TextPassword = (EditText) findViewById(R.id.editText);
        btnRegistrar = (Button) findViewById(R.id.InicioSesion);
        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        btnRegistrar.setOnClickListener(this);

        data.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    String usuario = dataSnapshot.child("usuario").getValue().toString();
                    TipoUsuario.setText(usuario);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void ingresar(){


        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password  = TextPassword.getText().toString().trim();

        if ((email.equals(paciente)) && (password.equals(clave))) {
            Intent i = new Intent(LogIn.this, menuPrincipal.class);
            startActivity(i);
        }
        else if ((email.equals(doctor)) && (password.equals(clave))){
            Intent i = new Intent(LogIn.this, menuPrincipal.class);
            startActivity(i);
        }

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //consultar si el usuario existe
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success

                        if(task.isSuccessful()){


                            referencia = FirebaseDatabase.getInstance().getReference();
                            firebaseAuth = FirebaseAuth.getInstance();
                            String id = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference paciente = referencia.child("Paciente").child(id).child("usuario");
                            DatabaseReference medico = referencia.child("Medico").child(id).child("usuario");


                            paciente.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                    if (dataSnapshot.exists()){
                                        int pos = email.indexOf("@");//verifica el caracter donde se encuentra en el email
                                        String user = email.substring(0,pos);// envia el email hasta donde se encuentra la posicion de la @
                                        Toast.makeText(LogIn.this,"Hola: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(LogIn.this,menuPrincipal.class);
                                        intent.putExtra(menuPrincipal.user, user);
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                            medico.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                    if (dataSnapshot.exists()){
                                        int pos = email.indexOf("@");//verifica el caracter donde se encuentra en el email
                                        String user = email.substring(0,pos);// envia el email hasta donde se encuentra la posicion de la @
                                        Toast.makeText(LogIn.this,"Hola: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(LogIn.this,inicioDoctor.class);
                                        intent.putExtra(menuPrincipal.user, user);
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                        } else {
                            Toast.makeText(LogIn.this, "Datos Erroneos ", Toast.LENGTH_LONG).show();
                        }

                        progressDialog.dismiss();
                    }
                });

    }


    @Override
    public void onClick(View view) {
        //Invocamos al método:
        ingresar();
    }

    public void buttonReggistrar(View view){

        Intent intent = new Intent(LogIn.this,registro.class);
        startActivity(intent);
    }
}
package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//nuevo codigo
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logIn extends AppCompatActivity {

    EditText email, password;
    Button btn_signUp;
    Button signIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);
        btn_signUp = findViewById(R.id.button);
        signIn = findViewById(R.id.InicioSesion);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = email.getText().toString();
                String pwd = password.getText().toString();


                if (emailID.isEmpty()){
                    email.setError("Ingresa tu dirección de correo");
                    email.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Ingresa tu contraseña");
                    password.requestFocus();
                }
                else if (emailID.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(logIn.this, "Completa los espacios vacios", Toast.LENGTH_SHORT).show();
                }
                else if (!(emailID.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emailID,pwd).addOnCompleteListener(logIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(logIn.this, "Inicio invalido, por favor intenta de nuevo", Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(logIn.this,menuPrincipal.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(logIn.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(logIn.this,login2.class);
                startActivity(i);
            }
        });
    }
}

/*public class logIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void buttonIniciarSesion(View view){
        Intent intent = new Intent(logIn.this, menuPrincipal.class);
        startActivity(intent);
    }
}*/

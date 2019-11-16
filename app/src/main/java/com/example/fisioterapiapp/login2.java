package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// nuevo

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
import com.google.firebase.auth.FirebaseUser;

public class login2 extends AppCompatActivity {

    EditText email, password;
    public String doctor =  "doctor";
    public String paciente =  "paciente";
    public String clave =  "admin";
    Button sigIn;
    Button btn_signIn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);
        btn_signIn = findViewById(R.id.InicioSesion);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser !=null){
                    Toast.makeText(login2.this, "ingresar", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login2.this, menuPrincipal.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(login2.this, "Ingresa de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = email.getText().toString();
                String pwd = password.getText().toString();

                if ((emailID.equals(doctor)) && (pwd.equals(clave))) {
                    Intent i = new Intent(login2.this, inicioDoctor.class);
                    startActivity(i);
                }
                else if ((emailID.equals(paciente)) && (pwd.equals(clave))){
                    Intent i = new Intent(login2.this, menuPrincipal.class);
                    startActivity(i);
                }
                else if (emailID.isEmpty()){
                    email.setError("Ingresa dirreción de correo");
                    email.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Ingresa yu contraseñña");
                    password.requestFocus();
                }
                else if (emailID.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(login2.this, "completa los espacios vacios", Toast.LENGTH_SHORT).show();
                }
                else if (!(emailID.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emailID,pwd).addOnCompleteListener(login2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(login2.this, "el inicio fue invalido, por favor intenta de  nuevo", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(login2.this,menuPrincipal.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(login2.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void buttonStartRegistro(View view){
        Intent intent = new Intent(login2.this, logIn.class);
        startActivity(intent);
    }


}
/*public class login2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }
}
*/
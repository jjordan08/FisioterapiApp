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
                    Toast.makeText(login2.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login2.this, menuPrincipal.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(login2.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = email.getText().toString();
                String pwd = password.getText().toString();

                if (emailID.isEmpty()){
                    email.setError("Please enter email address");
                    email.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else if (emailID.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(login2.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(emailID.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emailID,pwd).addOnCompleteListener(login2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(login2.this, "Login Failed, Please Login Again", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(login2.this,menuPrincipal.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(login2.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
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
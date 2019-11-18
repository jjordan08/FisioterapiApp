package com.example.fisioterapiapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //defining view objects
    private EditText TextEmail;
    private EditText TextPassword;
    private EditText TextName;
    private EditText TextApellido;
    private EditText TextCedula;
    private EditText TextEdad;
    private Spinner TextUsuario;
     String sexo ;
    RadioButton sexoF,sexoM;
    private ProgressDialog progressDialog;

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;
    private DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //creacion spineer para el registro de tipo de usuario
        Spinner spinner = findViewById(R.id.spinnerInicio);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.usuarios, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        data = FirebaseDatabase.getInstance().getReference();

        //Referenciamos los views
        TextEmail = (EditText) findViewById(R.id.editText2);
        TextPassword = (EditText) findViewById(R.id.editText);
        TextName = (EditText) findViewById(R.id.editText6);
        TextApellido = (EditText) findViewById(R.id.editText7);
        TextCedula = (EditText) findViewById(R.id.editText8);
        TextEdad = (EditText) findViewById(R.id.editText5);
        sexoM = (RadioButton)findViewById(R.id.radioButtonM);
        sexoF = (RadioButton)findViewById(R.id.radioButtonF);
        TextUsuario = (Spinner) findViewById(R.id.spinnerInicio);
        progressDialog = new ProgressDialog(this);

    }


    private void registrarUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        final String password  = TextPassword.getText().toString().trim();
        final String name = TextName.getText().toString().trim();
        final String apellido = TextApellido.getText().toString().trim();
        final String cedula = TextCedula.getText().toString().trim();
        final String edad = TextEdad.getText().toString().trim();
        if (sexoM.isChecked()) {
            sexo = sexoM.getText().toString();
        } else if (sexoF.isChecked()) {
            sexo = sexoF.getText().toString();
        }
        final String usuario = TextUsuario.getSelectedItem().toString();




        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            Intent intent = new Intent(registro.this, LogIn.class);
                            Toast.makeText(registro.this,"Se ha registrado el usuario con el email: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                            startActivity(intent);



                            Map<String, Object> map = new HashMap<>();
                            map.put("nombre",name);
                            map.put("apellido",apellido);
                            map.put("cedula",cedula);
                            map.put("edad",edad);
                            map.put("sexo",sexo);
                            map.put("usuario", usuario);
                            map.put("correo",email);
                            map.put("contraseña",password);


                            String id = firebaseAuth.getCurrentUser().getUid();
                            data.child("Usuarios").child(id).setValue(map);


                        }else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta colicion o esta registrado
                                Toast.makeText(registro.this, "Ya existe el usuario ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(registro.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    public void buttonRegistrar(View view){
       registrarUsuario();
    }


    public void buttonRegresar(View view){
        Intent intent = new Intent(registro.this, LogIn.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

package com.example.fisioterapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class asignados extends AppCompatActivity {

    public static final String user="names";
    TextView textUser1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignados);

        textUser1 = (TextView)findViewById(R.id.textView9);
        String user = getIntent().getStringExtra("names");
        textUser1.setText(""+user+"\nTu medico asignó los siguientes ejercicios 2 veces por día:");
    }
    //esto es un comentario de Jai Master.

    public void buttonRegresar(View view){
        Intent intent = new Intent(asignados.this, menuPrincipal.class);
        startActivity(intent);
    }
}

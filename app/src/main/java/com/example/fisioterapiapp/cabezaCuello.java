package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class cabezaCuello extends AppCompatActivity {

    public static final String user="names";
    TextView textUser;

    public int num ;
    public String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabeza_cuello);

        textUser = (TextView)findViewById(R.id.textView11);
        String user = getIntent().getStringExtra("names");
        textUser.setText(""+user+"\n1. Cabeza y Cuello");

        recibirDatos();
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(cabezaCuello.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }


    public void buttonccUnoUno(View view){
        Intent intent = new Intent(cabezaCuello.this, Imagenes.class);
        intent.putExtra("dato00","0");
        intent.putExtra("dato01","Ejercicio 1.1 de la cabeza y el cuello");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Incline la cabeza hacia atrás (mirando hacia arriba). Incline la cabeza hacia delante (mirando hacia abajo).");
        intent.putExtra("dato04","y-1yEDrcp0I");

        startActivity(intent);
    }

    public void buttonccUnoDos(View view){
        Intent intent = new Intent(cabezaCuello.this, Imagenes.class);
        intent.putExtra("dato00","1");
        intent.putExtra("dato01","Ejercicio 1.2 de la cabeza y el cuello");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Incline la cabeza en dirección al hombro (como si intentara alcanzar con la oreja el hombro y sin levantar éste).");
        intent.putExtra("dato04","TDh_b8bEIrY");
        startActivity(intent);
    }

    public void buttonccUnoTres(View view){
        Intent intent = new Intent(cabezaCuello.this, Imagenes.class);
        intent.putExtra("dato00","2");
        intent.putExtra("dato01","Ejercicio 1.3 de la cabeza y el cuello");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Gire la cabeza para mirar sobre el hombro.");
        intent.putExtra("dato04","iPAg0S91j1s");
        startActivity(intent);
    }
}

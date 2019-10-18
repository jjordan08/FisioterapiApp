package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tobilloPies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tobillo_pies);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(tobilloPies.this, Ejercicios.class);
        startActivity(intent);
    }

    public void buttonSeisUno(View view){
        Intent intent = new Intent(tobilloPies.this, Imagenes.class);
        intent.putExtra("dato00","19");
        intent.putExtra("dato01","Ejercicio 6.1 tobillos y pies");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble el pie hacia arriba." + '\n' + "Segundo: Doble el pie hacia abajo. Este ejercicio debe hacerse despacio. " +
                "Si siente como si fuera a tener un espasmo, entonces repita el primer paso y mantenga " +
                "la posición suavemente. Luego deje de hacer el ejercicio.");
        startActivity(intent);
    }

    public void buttonSeisDos(View view){
        Intent intent = new Intent(tobilloPies.this, Imagenes.class);
        intent.putExtra("dato00","20");
        intent.putExtra("dato01","Ejercicio 6.2 tobillos y pies");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Mueva el pie con la planta hacia afuera."+'\n'+"Segundo: Mueva el pie con la planta hacia adentro. ");
        startActivity(intent);
    }

    public void buttonSeisTres(View view){
        Intent intent = new Intent(tobilloPies.this, Imagenes.class);
        intent.putExtra("dato00","21");
        intent.putExtra("dato01","Ejercicio 6.3 tobillos y pies");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble los dedos del pie hacia adentro."+'\n'+"Segundo: Extienda los dedos del pie hacia arriba y atrás tanto como pueda.");
        startActivity(intent);
    }
}

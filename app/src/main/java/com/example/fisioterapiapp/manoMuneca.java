package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class manoMuneca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mano_muneca);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(manoMuneca.this, Ejercicios.class);
        startActivity(intent);
    }

    public void buttonCuatrouno(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","7");
        intent.putExtra("dato01","Ejercicio 4.1 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble los dedos hacia la palma (haga un puño)."+'\n'+"Segundo: Estire los dedos.");
        startActivity(intent);
    }

    public void buttonCuatroDos(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","8");
        intent.putExtra("dato01","Ejercicio 4.2 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble todas las articulaciones del pulgar."+'\n'+"Segundo: Descanse el pulgar. ");
        startActivity(intent);
    }

    public void buttonCuatroTres(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","9");
        intent.putExtra("dato01","Ejercicio 4.3 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","IPrimero: Separe los dedos extendiéndolos."+'\n'+"Segundo: Junte los dedos. ");
        startActivity(intent);
    }

    public void buttonCuatroCuatro(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","10");
        intent.putExtra("dato01","Ejercicio 4.4 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Con la palma hacia arriba, mueva el pulgar hacia arriba."+'\n'+"Segundo: Doble el pulgar. Tercero: Mueva el pulgar hasta que toque el dedo meñique.");
        startActivity(intent);
    }

    public void buttonCuatroCinco(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","11");
        intent.putExtra("dato01","Ejercicio 4.5 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Empiece con el brazo y muñeca en una posición cómoda, los dedos apuntando hacia el techo. " +'\n'+
                "Segundo: Doble solamente los nudillos grandes de los dedos (excepto el pulgar), formando un ángulo de 90º con la" +
                " palma de la mano. Suba los dedos rectos. Trate de mantener la muñeca relajada. ");
        startActivity(intent);
    }
}

package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class manoMuneca extends AppCompatActivity {

    public int num ;
    public String dato;

    public static final String user="names";
    TextView textUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mano_muneca);
        recibirDatos();

        textUser = (TextView)findViewById(R.id.textView17);
        String user = getIntent().getStringExtra("names");
        textUser.setText(""+user+"\n4. Mano y Muñeca");
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(manoMuneca.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonCuatrouno(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","7");
        intent.putExtra("dato01","Ejercicio 4.1 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble los dedos hacia la palma (haga un puño)."+'\n'+"Segundo: Estire los dedos.");
        intent.putExtra("dato04","T8y-4OG4YjY");

        startActivity(intent);
    }

    public void buttonCuatroDos(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","8");
        intent.putExtra("dato01","Ejercicio 4.2 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble todas las articulaciones del pulgar."+'\n'+"Segundo: Descanse el pulgar. ");
        intent.putExtra("dato04","WeyZqNPAxbQ");
        startActivity(intent);
    }

    public void buttonCuatroTres(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","9");
        intent.putExtra("dato01","Ejercicio 4.3 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","IPrimero: Separe los dedos extendiéndolos."+'\n'+"Segundo: Junte los dedos. ");
        intent.putExtra("dato04","vN7KCgWA3j4");
        startActivity(intent);
    }

    public void buttonCuatroCuatro(View view){
        Intent intent = new Intent(manoMuneca.this, Imagenes.class);
        intent.putExtra("dato00","10");
        intent.putExtra("dato01","Ejercicio 4.4 de la mano y muñeca");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Con la palma hacia arriba, mueva el pulgar hacia arriba."+'\n'+"Segundo: Doble el pulgar. Tercero: Mueva el pulgar hasta que toque el dedo meñique.");
        intent.putExtra("dato04","vzp8f6F2Ojo");
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
        intent.putExtra("dato04","RRfOUAx14C4");
        startActivity(intent);
    }
}

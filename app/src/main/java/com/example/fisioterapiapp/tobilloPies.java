package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tobilloPies extends AppCompatActivity {

    public int num ;
    public String dato;

    public static final String user="names";
    TextView textUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tobillo_pies);
        recibirDatos();

        textUser = (TextView)findViewById(R.id.textView15);
        String user = getIntent().getStringExtra("names");
        textUser.setText(""+user+"\n5. Tobillo y Pies");
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(tobilloPies.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
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
        intent.putExtra("dato04","PAuu8aDWTCg");
        startActivity(intent);
    }

    public void buttonSeisDos(View view){
        Intent intent = new Intent(tobilloPies.this, Imagenes.class);
        intent.putExtra("dato00","20");
        intent.putExtra("dato01","Ejercicio 6.2 tobillos y pies");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Mueva el pie con la planta hacia afuera."+'\n'+"Segundo: Mueva el pie con la planta hacia adentro. ");
        intent.putExtra("dato04","2X7QmwPnHwc");
        startActivity(intent);
    }

    public void buttonSeisTres(View view){
        Intent intent = new Intent(tobilloPies.this, Imagenes.class);
        intent.putExtra("dato00","21");
        intent.putExtra("dato01","Ejercicio 6.3 tobillos y pies");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Primero: Doble los dedos del pie hacia adentro."+'\n'+"Segundo: Extienda los dedos del pie hacia arriba y atrás tanto como pueda.");
        intent.putExtra("dato04","PAuu8aDWTCg");
        startActivity(intent);
    }
}

package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class codoAntebrazo extends AppCompatActivity {


    public int num ;
    public String dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codo_antebrazo);
        recibirDatos();
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(codoAntebrazo.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonTresUno(View view){
        Intent intent = new Intent(codoAntebrazo.this, Imagenes.class);
        intent.putExtra("dato00","5");
        intent.putExtra("dato01","Ejercicio 3.1 Codo y Antebrazo");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Acuéstese en la cama o sobre una colchoneta con los brazos “pegados” al cuerpo y las palmas de las " +
                "manos hacia arriba. Manteniendo el codo sobre la cama o colchoneta, flexione el codo llevando la mano tan cerca del hombro " +
                "como pueda. Mantenga esta posición. Vuelva a la posición original. Repita 3 veces este ejercicio con cada brazo. ");
        startActivity(intent);
    }

    public void buttonTresDos(View view){
        Intent intent = new Intent(codoAntebrazo.this, Imagenes.class);
        intent.putExtra("dato00","6");
        intent.putExtra("dato01","Ejercicio 3.2 Codo y Antebrazo");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Acuéstese de espaldas con los brazos al lado y las palmas hacia el costado (o bien siéntese en una mesa con " +
                "el antebrazo sobre la mesa). Levante el antebrazo recto. Si está  recostado, mantenga el codo y el brazo superior tocando la cama. " +
                "Gire suavemente la mano con la palma hacia su cara, y luego gire su mano poniendo la palma hacia afuera. Repita 2-3 veces. " +
                "Repita el ejercicio con el otro brazo.");
        startActivity(intent);
    }
}

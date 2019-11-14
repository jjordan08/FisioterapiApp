package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class troncoCadera extends AppCompatActivity {

    public int num ;
    public String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tronco_cadera);
        recibirDatos();
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view) {
        Intent intent = new Intent(troncoCadera.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonCincoUno(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "12");
        intent.putExtra("dato01", "Ejercicio 5.1 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Siéntese en una silla o a un lado de la cama, con los pies tocando el suelo. Doble la cadera levantando " +
                "la rodilla hacia el pecho. Mantenga ésta posición, luego vuelva a poner el pie en el suelo. Repita.");
        startActivity(intent);
    }

    public void buttonCincoDos(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "13");
        intent.putExtra("dato01", "Ejercicio 5.2 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Enderece la rodilla levantando un pie. Vuelva a la posición con la rodilla doblada. .");
        startActivity(intent);
    }

    public void buttonCincoTres(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "14");
        intent.putExtra("dato01", "Ejercicio 5.3 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "En posición boca abajo, doble la rodilla. Vuelva a la posición original");
        startActivity(intent);
    }

    public void buttonCincoCuatro(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "15");
        intent.putExtra("dato01", "Ejercicio 5.4 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Con las piernas juntas y rectas, extienda las piernas para que estén separadas y vuelva a la posición " +
                "original (también puede realizar este ejercicio extendiendo primero una pierna, volviendo a la primera posición y luego extendiendo la otra).");
        startActivity(intent);
    }

    public void buttonCincoCinco(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "16");
        intent.putExtra("dato01", "Ejercicio 5.5 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Recostado sobre su espalda, levante una rodilla y presiónela sobre el pecho mientras mantiene la otra " +
                "pierna recta sobre el suelo o la cama. Si este estiramiento le resulta muy difícil, mantenga la pierna flexionada sujetando la " +
                "pierna con las dos manos por detrás de la rodilla. Si todavía le sigue siendo difícil, ponga una  pierna plantada en el suelo y " +
                "suavemente “resbale” el talón hacia los glúteos. Mantenga esta posición durante al menos 15 segundos. Repita con cada lado");
        startActivity(intent);
    }

    public void buttonCincoSeis(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "17");
        intent.putExtra("dato01", "Ejercicio 5.6 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Recostado sobre su espalda con las rodillas dobladas y los pies plantados, baje las rodillas suavemente de " +
                "lado a lado. La idea es estirar el tronco y la cadera, sin que las rodillas toquen el suelo o la cama.");
        startActivity(intent);
    }

    public void buttonCincoSiete(View view) {
        Intent intent = new Intent(troncoCadera.this, Imagenes.class);
        intent.putExtra("dato00", "18");
        intent.putExtra("dato01", "Ejercicio 5.7 Tronco y Cadera");
        intent.putExtra("dato02", "Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03", "Doble una rodilla primero y luego la otra hacia el pecho para estirar la región lumbar. Mantenga esta posición " +
                "durante al menos 15 segundos. Después, baje un pie primero y luego el otro para evitar una lesión en la espalda");
        startActivity(intent);
    }
}

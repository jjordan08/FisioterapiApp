package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class hombros extends AppCompatActivity {

    public static final String user="names";
    TextView textUser;


    public int num ;
    public String dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombros);
        recibirDatos();

        textUser = (TextView)findViewById(R.id.textView14);
        String user = getIntent().getStringExtra("names");
        textUser.setText(""+user+"\n2. Hombros");
    }

    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        num = Integer.parseInt(extras.getString("dato00"));
        dato = String.valueOf(num);
    }

    public void buttonRegresar(View view){
        Intent intent = new Intent(hombros.this, Ejercicios.class);
        intent.putExtra("dato00", dato);
        startActivity(intent);
    }

    public void buttonccUnoUno(View view){
        Intent intent = new Intent(hombros.this, Imagenes.class);
        intent.putExtra("dato00","3");
        intent.putExtra("dato01","Ejercicio 2.1 Hombros");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","IAcuéstese de espaldas, brazos a los lados, con las palmas de la mano hacia arriba. Levante un brazo sobre la cabeza" +
                " (como levantando la mano en una clase), manteniendo el codo y el antebrazo lo más rectos posible. Mientras está en" +
                " esta posición, respire profundamente y espire una vez en forma rítmica. Baje el brazo a la posición original " +
                "como comenzó y repita 2-3 veces. Repita este ejercicio con el otro brazo.");
        intent.putExtra("dato04","Gu8Yal6oVfE");
        startActivity(intent);
    }

    public void buttonccUnoDos(View view){
        Intent intent = new Intent(hombros.this, Imagenes.class);
        intent.putExtra("dato00","4");
        intent.putExtra("dato01","Ejercicio 2.2 Hombros");
        intent.putExtra("dato02","Permanezca en la posición indicada un tiempo mínimo de 20’’ y tenga en cuenta las  precauciones señaladas abajo");
        intent.putExtra("dato03","Acuéstese de espaldas con los brazos a los lados. Gire las palmas hacia arriba. Estire un brazo y levántelo" +
                " recto hacia fuera, hasta que llegue al lado de su cabeza (como un movimiento de títere). Vuelva el brazo a la posición original" +
                " y repita 2-3  veces. Repita con el otro brazo. ");
        intent.putExtra("dato04","8Wa0zX6V4yg");
        startActivity(intent);
    }

}

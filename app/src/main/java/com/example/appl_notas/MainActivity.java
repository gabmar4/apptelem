package com.example.appl_notas;


import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button  button_sig =(Button) findViewById(R.id.button_sig);

        button_sig.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {


                Intent intento = new Intent(MainActivity.this, Asignaturas.class);
                Bundle b = new Bundle();

                String asignatura = ((EditText) findViewById(R.id.asignatura)).getText().toString();
                int nota_1 = Integer.valueOf( ((EditText) findViewById(R.id.nota_1) ).getText().toString()) ;

                b.putString("Nombre asignatura :", asignatura);
                b.putInt("Nota :" ,nota_1);

                intento.putExtras(b);
                startActivity(intento);
            }
        });
    }
}

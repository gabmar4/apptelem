package com.example.appl_notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Asignaturas extends AppCompatActivity {
    Bundle b;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

       b=getIntent().getExtras();
        String asignatura=b.getString("Nombre asignatura :");
        int nota_1=b.getInt("Nota :");


        ((TextView) findViewById(R.id.texto_asig)).setText(asignatura.toUpperCase()+" con media: "+nota_1);


    }
}

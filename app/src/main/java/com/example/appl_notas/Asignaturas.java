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
        double nota_1=b.getDouble("Nota1");
        double nota_2=b.getDouble("Nota2");
        double nota_p=b.getDouble("Notap");
        double nota_ot=b.getDouble("Notaot");

        int p_nota1=b.getInt("Nota1p");
        int p_nota2=b.getInt("Nota2p");
        int p_notap=b.getInt("Notapp");
        int p_nota_ot=b.getInt("Notaotp");
//el porcentaje de cada nota es un entero
        double media1=(nota_1*p_nota1+nota_2*p_nota2+nota_p*p_notap)/100;
        if(nota_ot!=0){
            media1=media1+(nota_ot*p_nota_ot)/100;

        }



        ((TextView) findViewById(R.id.texto_asig)).setText(asignatura.toUpperCase()+" con media: "+media1);


    }
}

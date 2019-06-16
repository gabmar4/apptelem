package com.example.appl_notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Asignaturas extends AppCompatActivity {
    Bundle b;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
       b=getIntent().getExtras();

       Bundle asign=getIntent().getExtras();
       String asignatura="";
       asignatura=asign.getString("Nombre asignatura :");

        double nota_1=b.getDouble("Nota1");
        double nota_2=b.getDouble("Nota2");
        double nota_p=b.getDouble("Notap");
        double nota_ot=b.getDouble("Notaot");

        double p_nota1=b.getDouble("Nota1p");
        double p_nota2=b.getDouble("Nota2p");
        double p_notap=b.getDouble("Notapp");
        double p_nota_ot=b.getDouble("Notaotp");
//el porcentaje de cada nota es un double ahora
        double media1=(nota_1*p_nota1+nota_2*p_nota2+nota_p*p_notap+nota_ot*p_nota_ot)/100;

        if(asignatura.equals("Aplicaciones Telemáticas")) {
            ((TextView) findViewById(R.id.media_at)).setText("Media: " + media1);
        }
        if(asignatura.equals("Radiocomunicaciones")) {
           ((TextView) findViewById(R.id.media_ra)).setText("Media: " + media1);
        }
       if(asignatura.equals("Lineas")) {
           ((TextView) findViewById(R.id.media_li)).setText("Media: " + media1);
       }
       if(asignatura.equals("Comunicaciones Multimedia")) {
           ((TextView) findViewById(R.id.media_cm)).setText("Media: " + media1);
       }
       if(asignatura.equals("Comunicaciones Ópticas")) {
           ((TextView) findViewById(R.id.media_co)).setText("Media: " + media1);
       }
       if(asignatura.equals("Comunicaciones Digitales")) {
           ((TextView) findViewById(R.id.media_cd)).setText("Media: " + media1);
       }
        else{
            ((TextView) findViewById(R.id.text_error)).setText("error ");

        }
    }
}

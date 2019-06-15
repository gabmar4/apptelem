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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button  button_sig =(Button) findViewById(R.id.button_sig);

        button_sig.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {

//podria usar un bucle if para comprobar que se cumplen los porcentajes
                Intent intento = new Intent(MainActivity.this, Asignaturas.class);
                Bundle b = new Bundle();

                String asignatura = ((EditText) findViewById(R.id.asignatura)).getText().toString();
                int nota_1 = Integer.valueOf(((EditText) findViewById(R.id.nota_1) ).getText().toString() ) ;
                int nota_2 = Integer.valueOf(((EditText) findViewById(R.id.nota_2) ).getText().toString() ) ;
                int nota_p = Integer.valueOf(((EditText) findViewById(R.id.nota_p) ).getText().toString() ) ;
                int nota_ot = Integer.valueOf(((EditText) findViewById(R.id.nota_ot) ).getText().toString() ) ;

                int pnota_1=Integer.valueOf(((EditText) findViewById(R.id.p_nota1)).getText().toString());
                int pnota_2=Integer.valueOf(((EditText) findViewById(R.id.p_nota2)).getText().toString());
                int pnota_p=Integer.valueOf(((EditText) findViewById(R.id.p_notap)).getText().toString());
                int pnota_ot=Integer.valueOf(((EditText) findViewById(R.id.p_nota_ot)).getText().toString());


                int sum=pnota_1+pnota_2+pnota_p+pnota_ot;

                b.putString("Nombre asignatura :", asignatura);
                b.putInt("Nota1" ,nota_1);
/*                b.putInt("Nota2" ,nota_2);
                b.putInt("Notap" ,nota_p);
                b.putInt("Notaot" ,nota_ot);

                b.putInt("Nota1p" ,pnota_1);
                b.putInt("Nota2p" ,pnota_2);
                b.putInt("Notapp" ,pnota_p);
                b.putInt("Notaotp" ,pnota_ot);
*/
                TextView error_p=(TextView) findViewById(R.id.Error_porcentaje);

                intento.putExtras(b);
/*
                if((nota_1>10)&&(nota_2>10)&&(nota_p>10)&&(nota_ot>10)){
                    error_p.setText("La nota no puede ser mayor de 10");
                    finish();

                    startActivity(getIntent());

                }
*/
                if(sum==100) {
                    startActivity(intento);
                }
                else{
                    error_p.setText("El porcentaje de las notas tiene que ser igual a 100");

                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }

                    finish();

                    startActivity(getIntent());
                }
            }
        });



    }
}

package com.example.appl_notas;


import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
        double nota_1=0;
        final Button  button_sig =(Button) findViewById(R.id.button_sig);

        button_sig.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {

//podria usar un bucle if para comprobar que se cumplen los porcentajes
                Intent intento = new Intent(MainActivity.this, Asignaturas.class);
                Bundle b = new Bundle();

                EditText etasignatura=(EditText) findViewById(R.id.asignatura);
                String asignatura = etasignatura.getText().toString();

                if(TextUtils.isEmpty(asignatura)){
                    etasignatura.setError("No has introducido el nombre de la asignatura");
                    return;
                }
                double nota_1=0,nota_2=0,nota_p=0,nota_ot=0;
                int pnota_1=0,pnota_2 =0,pnota_p =0,pnota_ot =0;

                nota_1 = Double.parseDouble(((EditText) findViewById(R.id.nota_1) ).getText().toString() ) ;
                nota_2 = Double.parseDouble(((EditText) findViewById(R.id.nota_2) ).getText().toString() ) ;
                nota_p = Double.parseDouble(((EditText) findViewById(R.id.nota_p) ).getText().toString() ) ;
                nota_ot = Double.parseDouble(((EditText) findViewById(R.id.nota_ot) ).getText().toString() ) ;

                pnota_1=Integer.valueOf(((EditText) findViewById(R.id.p_nota1)).getText().toString());
                pnota_2=Integer.valueOf(((EditText) findViewById(R.id.p_nota2)).getText().toString());
                pnota_p=Integer.valueOf(((EditText) findViewById(R.id.p_notap)).getText().toString());
                pnota_ot=Integer.valueOf(((EditText) findViewById(R.id.p_nota_ot)).getText().toString());

/*                if(nota_ot.isEmpty()||nota_ot.length()==0||nota_ot.equals("")){
                    nota_ot=0;
                }
                if(pnota_ot.isEmpty()||pnota_ot.length()==0||pnota_ot.equals("")){
                    pnota_ot=0;
                }
*/
                int sum=pnota_1+pnota_2+pnota_p+pnota_ot;

                b.putString("Nombre asignatura :", asignatura);
                b.putDouble("Nota1" ,nota_1);
                b.putDouble("Nota2" ,nota_2);
                b.putDouble("Notap" ,nota_p);
                b.putDouble("Notaot" ,nota_ot);

                b.putInt("Nota1p" ,pnota_1);
                b.putInt("Nota2p" ,pnota_2);
                b.putInt("Notapp" ,pnota_p);

                b.putInt("Notaotp" ,pnota_ot);

                TextView error_p=(TextView) findViewById(R.id.Error_porcentaje);

                intento.putExtras(b);

                if(((nota_1>10)||(nota_2>10))||((nota_p>10)||(nota_ot>10))){
                    error_p.setText("Una de las notas es mayor que 10.");

                    try {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }//retardo para poder leer el mensaje
                    Intent intent1=getIntent();
                    finish();
                    startActivity(intent1);

                }
                else {
                    if (sum == 100) {
                        startActivity(intento);
                    } else {
                        error_p.setText("El porcentaje total de las notas tiene que ser igual a 100");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }//retardo para poder leer el mensaje

                        finish();
                        startActivity(getIntent());
                    }
                }
            }
        });



    }
}

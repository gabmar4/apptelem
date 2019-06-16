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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button  button_sig =(Button) findViewById(R.id.button_sig);
        final Button  button_new =(Button) findViewById(R.id.button_new);
        final Button  button_rst =(Button) findViewById(R.id.button_rst);

        final TextView te_contador =(TextView) findViewById(R.id.te_contador);

        int contador=1;

        button_sig.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {

                Intent intento = new Intent(MainActivity.this, Asignaturas.class);
                Bundle b = new Bundle();

                EditText etasignatura=(EditText) findViewById(R.id.asignatura);
                String asignatura = etasignatura.getText().toString();

                if(TextUtils.isEmpty(asignatura)){
                    etasignatura.setError("No has introducido el nombre de la asignatura");
                    return;
                }

                EditText etnota_1=(EditText) findViewById(R.id.nota_1);
                EditText etnota_2=(EditText) findViewById(R.id.nota_2);
                EditText etnota_p=(EditText) findViewById(R.id.nota_p);
                EditText etnota_ot=(EditText) findViewById(R.id.nota_ot);
                EditText etpnota_1=(EditText) findViewById(R.id.p_nota1);
                EditText etpnota_2=(EditText) findViewById(R.id.p_nota2);
                EditText etpnota_p=(EditText) findViewById(R.id.p_notap);
                EditText etpnota_ot=(EditText) findViewById(R.id.p_nota_ot);



                double nota_1 = ParseDouble(etnota_1.getText().toString());
                double nota_2 = ParseDouble(etnota_2.getText().toString() ) ;
                double nota_p = ParseDouble(etnota_p.getText().toString() ) ;
                double nota_ot = ParseDouble(etnota_ot.getText().toString() ) ;

                double pnota_1=ParseDouble(etpnota_1.getText().toString());
                double pnota_2=ParseDouble(etpnota_2.getText().toString());
                double pnota_p=ParseDouble(etpnota_p.getText().toString());
                double pnota_ot=ParseDouble(etpnota_ot.getText().toString());




                b.putString("Nombre asignatura :", asignatura);
                b.putDouble("Nota1" ,nota_1);
                b.putDouble("Nota2" ,nota_2);
                b.putDouble("Notap" ,nota_p);
                b.putDouble("Notaot" ,nota_ot);

                b.putDouble("Nota1p" ,pnota_1);
                b.putDouble("Nota2p" ,pnota_2);
                b.putDouble("Notapp" ,pnota_p);
                b.putDouble("Notaotp" ,pnota_ot);

                TextView error_p=(TextView) findViewById(R.id.Error_porcentaje);

                double sum=pnota_1+pnota_2+pnota_p+pnota_ot;
                intento.putExtras(b);

                te_contador.setText("Hay "+(++contador)+" asignatura(s)");

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
                        error_p.setText("El porcentaje total de las notas tiene que ser igual a 100 y no a  "+sum+ ".");

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }//retardo para poder leer el mensaje

                        finish();
                        startActivity(getIntent());
                    }
                }
            }
        });

        button_rst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                contador +=1;
                finish();
                startActivity(getIntent());
            }
        });

    }



    double ParseDouble (String strNumber){
        if(strNumber !=null && strNumber.length()>0){
            try{
                return Double.parseDouble(strNumber);
            }catch (Exception e){
                return 0;
            }

        }
        else return 0;
    }//este metodo comprueba si el texto es null o vacio y devuelve el numero si no es vacio o un 0 si es vacio
}

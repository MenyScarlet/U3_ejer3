package com.example.scarlet.u3_ejer3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etNombre, etTelefono, etSueldo, etPrima, etTotal;
    Spinner spDia, spMes, spYear;
    Button btnIva;
    int prima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        etSueldo = (EditText)findViewById(R.id.etSueldo);
        etPrima = (EditText)findViewById(R.id.etPrima);
        etTotal = (EditText)findViewById(R.id.etTotal);
        spDia = (Spinner) findViewById(R.id.spDia);
        spMes = (Spinner) findViewById(R.id.spMes);
        spYear = (Spinner) findViewById(R.id.spYear);
        btnIva = (Button) findViewById(R.id.btnIva);
        prima = 0;

        //Info Spinners dia, mes y año
        String [] dia = {"", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30", "31" };
        ArrayAdapter <String> adaptadorDia = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, dia);
        spDia.setAdapter(adaptadorDia);

        String [] mes = {"", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12"};
        ArrayAdapter <String> adaptadorMes = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, mes);
        spMes.setAdapter(adaptadorMes);

        String [] year = {"", "2018", "2017", "2016"};
        ArrayAdapter <String> adaptadorYear = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, year);
        spYear.setAdapter(adaptadorYear);



    }//FIN onCreate

    public void clickIva(View view) {

        String cajaSueldo = etSueldo.getText().toString();
        if (cajaSueldo.equals("")){

            Toast.makeText(getApplicationContext(), "Debes de rellenar el sueldo",
                    Toast.LENGTH_LONG).show();

        }else{
            double sueldo = Double.parseDouble(cajaSueldo);
            double sueldoNuevo = sueldo - (sueldo * 0.10);
            etSueldo.setText(sueldoNuevo+"");
            btnIva.setEnabled(false); //Para bloquear el boton cuando ya se ha pulsado
            etSueldo.setEnabled(false);//Para bloquear la caja
            btnIva.setText("Aplicado");//Para cambiar el text del boton cuando ya ha sido pulsado
        }

    }


    public void clickMas(View view) {
        //prima++; Sumar de 1 en 1
        if (prima<100){
            prima = prima+10;
            etPrima.setText(prima+"");
        }



    }



    public void clickMenos (View view) {
        //prima--; Restas de 1 en 1

        if (prima>0){
            prima=prima-10;
            etPrima.setText(prima+"");
        }

    }

    public void clickVer (View view) {

        //La combersion se puede hacer de dos formas, la primera es esta:
        double sueldo = Double.parseDouble(etSueldo.getText().toString());
        //y la segunda esta:
        String cajaPrima = etPrima.getText().toString();
        int prima = Integer.parseInt(cajaPrima);
        //Cualquiera de las dos es valida
        double total = sueldo + prima;

        etTotal.setText(total+"");

    }

    public void clickGeneral (View view) {
        //Recoger el valor de la caja de texto Completo
        String nombreCompleto = etNombre.getText().toString();

        //Comprobar si el nombre esta vacio
        if(nombreCompleto.equals("") || nombreCompleto.length()==0){//length es la longitud del
            // nombre para que los espacios no entren en el EditText.
            Toast.makeText(getApplicationContext(), "Debes de rellenar un nombre",
                    Toast.LENGTH_LONG).show();
        }else{
            //Split: devuelve un array de String separados por el valor que le demos
            String [] arrayNombre = nombreCompleto.split(" ");
            //Si el arrayNombre tiene menos de 3 posiciones avisamos al usuario
            if (arrayNombre.length<3){
                Toast.makeText(getApplicationContext(), "El formato del nombre no es correcto.\n" +
                                "Formato: Nombre Apellido1 Apellido2",
                        Toast.LENGTH_LONG).show();
            }else{
                int tamArray = arrayNombre.length;
                String apellido2 = arrayNombre [tamArray-1];
                String apellido1 = arrayNombre [tamArray-2];

                int tamRestante = tamArray-2;

                String nombre = "";
                for (int i=0; i<=tamRestante; i++){
                    nombre+=arrayNombre[i]+" ";
                }
                Toast.makeText(getApplicationContext(),
                        "Nombre: "+nombre+" Apellido1: "+apellido1+" Apellido2: "+apellido2,
                        Toast.LENGTH_LONG).show();
            }

        }

        //Comprobar Telefono
        String cajaTelefono = etTelefono.getText().toString();

        if (cajaTelefono.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de rellenar el teléfono",
                    Toast.LENGTH_LONG).show();
        }else{
            //Convertir el valor string a int
            int telefono = Integer.parseInt(cajaTelefono);

            if (telefono<600000000 || telefono>999999999){
                Toast.makeText(getApplicationContext(),
                        "Formato incorrecto debe de comenzar por 6, 7, 8 o 9",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Telefono correcto" +telefono,
                        Toast.LENGTH_LONG).show();
            }

        }


    }

}//FIN MainActivity

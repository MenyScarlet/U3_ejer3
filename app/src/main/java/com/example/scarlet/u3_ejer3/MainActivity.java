package com.example.scarlet.u3_ejer3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etTelefono, etSueldo, etPrima, etTotal;
    Spinner spDia, spMes, spYear;

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

        //Info Spinners dia, mes y año
        String [] dia = {"", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28" };
        ArrayAdapter <String> adaptadorDia = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, dia);
        spDia.setAdapter(adaptadorDia);

        String [] mes = {"", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12"};
        ArrayAdapter <String> adaptadorMes = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, mes);
        spMes.setAdapter(adaptadorMes);

        String [] year = {"", "2.000", "1.999", "1.998", "1.997", "1.996",
                "1.995", "1.994", "1.993", "1.992", "1.991",
                "1.990"};
        ArrayAdapter <String> adaptadorYear = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, mes);
        spYear.setAdapter(adaptadorYear);



    }//FIN onCreate

}//FIN MainActivity

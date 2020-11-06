package com.example.ev2_silvana_medina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Prestamo_Act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo_);



        spin1 = (Spinner)findViewById(R.id.spinCliente);
        spin2 = (Spinner)findViewById(R.id.spinCredito);
        tv = (TextView)findViewById(R.id.Resultado);


        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");


        ArrayAdapter<String> adapterClientes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapterCreditos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);


        spin1.setAdapter(adapterClientes);
        spin2.setAdapter(adapterCreditos);
    }




}


package com.example.ev2_silvana_medina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Credito;

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
    public void CalcularPrestamo(View view){
        Credito credito = new Credito();
        Clientes cliente = new Clientes();


        String seleccionCliente = spin1.getSelectedItem().toString();
        String seleccionCreditos = spin2.getSelectedItem().toString();


        int prestamo = 0;


        if(!seleccionCliente.isEmpty() && !seleccionCreditos.isEmpty()) {
            if (seleccionCliente.equals("Axel") && seleccionCreditos.equals("Credito Hipotecario")) {
                prestamo = cliente.getAxel() + credito.getCreditoHipotecario();
            }
            if (seleccionCliente.equals("Axel") && seleccionCreditos.equals("Credito Automotriz")) {
                prestamo = cliente.getAxel() + credito.getCreditoAutomotriz();
            }
            if (seleccionCliente.equals("Roxana") && seleccionCreditos.equals("Credito Hipotecario")) {
                prestamo = cliente.getRoxana() + credito.getCreditoHipotecario();
            }
            if (seleccionCliente.equals("Roxana") && seleccionCreditos.equals("Credito Automotriz")) {
                prestamo = cliente.getRoxana() + credito.getCreditoAutomotriz();
            }
            if (seleccionCliente.equals("Matias") && seleccionCreditos.equals("Credito Hipotecario")){
                prestamo = cliente.getMatias() + credito.getCreditoHipotecario();
            }
            if (seleccionCliente.equals("Matias") && seleccionCreditos.equals("Credito Automotriz")){
                prestamo = cliente.getMatias() + credito.getCreditoAutomotriz();
            }
            if (seleccionCliente.equals("Betzabe") && seleccionCreditos.equals("Credito Hipotecario")){
                prestamo = cliente.getBetzabe() + credito.getCreditoHipotecario();
            }
            if (seleccionCliente.equals("Betzabe") && seleccionCreditos.equals("Credito Automotriz")){
                prestamo = cliente.getBetzabe() + credito.getCreditoAutomotriz();
            }
            tv.setText("$ " + prestamo);
        } else {
            Toast.makeText(this, "Seleccione una opcion disponible", Toast.LENGTH_SHORT).show();
        }
    }


    public void CalcularDeudas(View view){
        Credito credito = new Credito();
        Clientes cliente = new Clientes();


        String seleccionCliente = spin1.getSelectedItem().toString();
        String seleccionCreditos = spin2.getSelectedItem().toString();


        int prestamo = 0;


        if(!seleccionCliente.isEmpty() && !seleccionCreditos.isEmpty()) {
            if (seleccionCliente.equals("Axel") && seleccionCreditos.equals("Credito Hipotecario")) {
                prestamo = (cliente.getAxel() + credito.getCreditoHipotecario()) / 12;
            }
            if (seleccionCliente.equals("Axel") && seleccionCreditos.equals("Credito Automotriz")) {
                prestamo = (cliente.getAxel() + credito.getCreditoAutomotriz()) / 8;
            }
            if (seleccionCliente.equals("Roxana") && seleccionCreditos.equals("Credito Hipotecario")) {
                prestamo = (cliente.getRoxana() + credito.getCreditoHipotecario()) / 12;
            }
            if (seleccionCliente.equals("Roxana") && seleccionCreditos.equals("Credito Automotriz")) {
                prestamo = (cliente.getRoxana() + credito.getCreditoAutomotriz()) / 8;
            }
            if (seleccionCliente.equals("Matias") && seleccionCreditos.equals("Credito Hipotecario")){
                prestamo = (cliente.getMatias() + credito.getCreditoHipotecario()) / 12;
            }
            if (seleccionCliente.equals("Matias") && seleccionCreditos.equals("Credito Automotriz")){
                prestamo = (cliente.getMatias() + credito.getCreditoAutomotriz()) / 8;
            }
            if (seleccionCliente.equals("Betzabe") && seleccionCreditos.equals("Credito Hipotecario")){
                prestamo = (cliente.getBetzabe() + credito.getCreditoHipotecario()) / 12;
            }
            if (seleccionCliente.equals("Betzabe") && seleccionCreditos.equals("Credito Automotriz")){
                prestamo = (cliente.getBetzabe() + credito.getCreditoAutomotriz()) / 8;
            }
            tv.setText("$ " + prestamo);
        } else {
            Toast.makeText(this, "Seleccione una opcion disponible", Toast.LENGTH_SHORT).show();
        }
    }
}







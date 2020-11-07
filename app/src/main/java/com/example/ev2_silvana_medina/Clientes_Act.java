package com.example.ev2_silvana_medina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_Act extends AppCompatActivity {

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_);

        et1 = (EditText) findViewById(R.id.edit1);
        et2 = (EditText) findViewById(R.id.edit2);
        et3 = (EditText) findViewById(R.id.edit3);

    }

    public void GuardarCliente (View V) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if (!et1.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();


            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("Salario", et3.getText().toString());




            db.insert("insumo", "null", registro);
            db.close();
            Toast.makeText(this, "se ha guardado el cliente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "debe rellenar los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void MostrarCliente (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = et1.getText().toString();
        if(!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, salario, stock FROM clientes WHERE codigo="+ codigo,null);
            if(fila.moveToFirst()) {




                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));


            }
        }else{
            Toast.makeText(this,"no hay cliente asociado al codigo", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String  codigo = et1.getText().toString();
        db.delete("Clientes", "codigo="+codigo, null);
        db.close();
        Toast.makeText(this,"Has eliminado un cliente", Toast.LENGTH_LONG).show();


    }
    public void ActualizarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Clientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String  codigo = et1.getText().toString();


        ContentValues cont = new ContentValues();


        cont.put("codigo", et1.getText().toString());
        cont.put("nombre", et2.getText().toString());
        cont.put("salario", et3.getText().toString());




        if(!codigo.isEmpty()){
            db.update("insumo",cont,"codigo="+codigo,null);


            Toast.makeText(this,"has actualizado un campo",Toast.LENGTH_LONG).show();
        }
    }
}



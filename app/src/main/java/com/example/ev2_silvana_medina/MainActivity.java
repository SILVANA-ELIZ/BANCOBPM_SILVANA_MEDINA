package com.example.ev2_silvana_medina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;
    private EditText edit, edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Task().execute();
            }
        });
        pb.setVisibility(View.INVISIBLE);
    }


    class Task extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {


            pb.setVisibility(View.VISIBLE);
        }




        @Override
        protected String doInBackground(String... strings) {


            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);


                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }




        @Override
        protected void onPostExecute(String s) {


            pb.setVisibility(View.INVISIBLE);


            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);


        }


    }

    public void Iniciar(View v)
    {
        if ((edit.getText().toString().equals("android")) || (edit.getText().toString().equals("android")))
        {
            if (edit2.getText().toString().equals("123"))
            {
                Intent i = new Intent(this,Home_act.class);
                startActivity(i);
            }
        }
    }
}


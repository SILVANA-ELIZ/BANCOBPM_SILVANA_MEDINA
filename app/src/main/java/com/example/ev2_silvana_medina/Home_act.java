package com.example.ev2_silvana_medina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.vf);


        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }


    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);


        vf.addView(view);
        vf.setFlipInterval(2500);
        vf.setAutoStart(true);
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    public void Seguridad (View v)
    {
        Intent i = new Intent(this, Secure_Act.class);
        startActivity(i);
    }


    public void Info(View v)
    {
        Intent i = new Intent(this, Info_Act.class);
        startActivity(i);
    }


    public void Clientes(View v)
    {
        Intent i = new Intent(this, Clientes_Act.class);
        startActivity(i);
    }




}




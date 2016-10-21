package com.example.joser.paint;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //variables
    ImageButton negro;
    ImageButton azul;
    ImageButton rojo;
    ImageButton amarillo;
    ImageButton verde;
    Lienzo lienzo;
    String color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        negro = (ImageButton) findViewById(R.id.colorNegro);
        azul = (ImageButton)findViewById(R.id.colorAzul);
        rojo = (ImageButton)findViewById(R.id.colorRojo);
        amarillo = (ImageButton)findViewById(R.id.colorAmarillo);
        verde = (ImageButton)findViewById(R.id.colorVerde);
        lienzo = (Lienzo)findViewById(R.id.lienzo);

        negro.setOnClickListener(this);
        azul.setOnClickListener(this);
        rojo.setOnClickListener(this);
        amarillo.setOnClickListener(this);
        verde.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.colorNegro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorAzul:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorRojo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorAmarillo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorVerde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            default:
                break;
        }
    }
}

package com.example.josue.convert;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Convert extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    String text1,text2, moneda;
    float multi =0, value=0, result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        text1 = settings.getString("spiner1","MXN");
        text2 = settings.getString("spiner2","MXN");
        TextView galleta1 = (TextView) findViewById(R.id.galleta1);
        TextView galleta2 = (TextView) findViewById(R.id.galleta2);
        galleta1.setText(text1);
        galleta2.setText(text2);
    }

    public void select(View view){
        startActivity(new Intent(getApplicationContext(), Select.class));
    }
    public void convert(View view) {
        if (text1.equals("MXN") && text2.equals("Dollars")) {
            multi = 0.05302f;
            moneda = " Dollars";
        }
        if (text1.equals("MXN") && text2.equals("Euros")) {
            multi = 0.0471918113f;
            moneda = " Euros";
        }
        if (text1.equals("Euros") && text2.equals("MXN")) {
            multi = 21.1901169f;
            moneda = " MXN";
        }
        if (text1.equals("Euros") && text2.equals("Dollars")) {
            multi = 1.1235f;
            moneda = " Dollars";
        }
        if (text1.equals("Dollars") && text2.equals("MXN")) {
            multi = 18.860807f;
            moneda = " MXN";
        }
        if (text1.equals("Dollars") && text2.equals("Euros")) {
            multi = 0.890075656f;
            moneda = " Euros";
        }
        EditText convertunit = (EditText) findViewById(R.id.editText);
        if (convertunit.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor ingrese un numero", Toast.LENGTH_LONG).show();
        } else {
            if (convertunit.getText().toString().matches("[0-9]+(\\.[0-9]+)?")) {
                value = Float.parseFloat(convertunit.getText().toString());
                result = value * multi;
                Toast.makeText(getApplicationContext(), Float.toString(result)+moneda, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Por favor ingrese solo numeros", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert, menu);
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
}

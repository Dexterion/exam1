package com.example.josue.convert;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Select extends AppCompatActivity {
    Spinner Spinner1, Spinner2;
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
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
        Spinner1 = (Spinner)findViewById(R.id.spinner);
        Spinner2 = (Spinner)findViewById(R.id.spinner2);
        String[] planets = getResources().getStringArray(R.array.planets_array);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, planets);
        Spinner1.setAdapter(myAdapter);
        Spinner2.setAdapter(myAdapter);
    }
    public void send(View view){
        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        Spinner mySpinner2=(Spinner) findViewById(R.id.spinner2);
        String text1 = mySpinner.getSelectedItem().toString();
        String text2 = mySpinner2.getSelectedItem().toString();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("spiner1", text1);
        editor.putString("spiner2", text2);

        // Commit the edits!
        editor.commit();
        finish();
        startActivity(new Intent(getApplicationContext(), Convert.class));
    }
}

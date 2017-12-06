package com.example.nesrine.e_learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewConf extends AppCompatActivity {
    Button b;
    EditText titr, adresse, dateConf, heurD, heurF,descp;
    String titre, ad, dConf, hD, hF, desp, form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conf);
        titr = (EditText)findViewById(R.id.t1);
        adresse = (EditText)findViewById(R.id.t2);
        dateConf = (EditText)findViewById(R.id.t3);
        heurD = (EditText)findViewById(R.id.t4);
        heurF = (EditText)findViewById(R.id.t5);
        descp = (EditText)findViewById(R.id.t6);
        b = (Button)findViewById(R.id.b);
    }
    public void addConfer(View view)
    {
        MainActivity mainActivity = new MainActivity();
       form= mainActivity.getPs();
    }
}

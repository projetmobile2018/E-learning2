package com.example.nesrine.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormateurMenu extends AppCompatActivity {
    Button myConf, addConf, otherConf;
    String ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formateur_menu);
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
        myConf = (Button)findViewById(R.id.b1);
        addConf =(Button)findViewById(R.id.b2);
        otherConf =(Button)findViewById(R.id.b3);
    }
    //Methode OnClick for Button My conferences
    public void ShowMy(View view)
    {
        Intent intent = new Intent(this,MyConferences.class);
        intent.putExtra("ps",ps);
        startActivity(intent);
    }
    //Methode Onclick for Button add Conference
    public void  AddCon(View view)
    {
        Intent intent = new Intent(this,NewConf.class);
        intent.putExtra("ps",ps);
        startActivity(intent);
    }
    //Methode OnClick for Button other Conférences
    public void autConf(View view)
    {
        Intent intent = new Intent(this,OtherConferences.class);
        intent.putExtra("ps",ps);
        startActivity(intent);

    }
}

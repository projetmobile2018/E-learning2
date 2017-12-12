package com.example.nesrine.e_learning;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewConf extends AppCompatActivity {
    Button b;
    EditText titr, adresse, dateConf, heurD, heurF,descp;
    String titre, ad, dConf, hD, hF, desp, form;
    int duration = Toast.LENGTH_LONG;
    SQLiteDatabase SQ;
    String ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conf);
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
        titr = (EditText)findViewById(R.id.t1);
        adresse = (EditText)findViewById(R.id.t2);
        dateConf = (EditText)findViewById(R.id.t3);
        heurD = (EditText)findViewById(R.id.t4);
        heurF = (EditText)findViewById(R.id.t5);
        descp = (EditText)findViewById(R.id.t6);
        b = (Button)findViewById(R.id.updateB);
    }
    public void addConfer(View view)
    {
       form= ps;
        titre= titr.getText().toString();
        ad = adresse.getText().toString();
        dConf = dateConf.getText().toString();
        hD = heurD.getText().toString();
        hF = heurF.getText().toString();
        desp = descp.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
        SimpleDateFormat simple = new SimpleDateFormat("hh:mm");
        Date heureDebut = new Date();
        Date heureFin = new Date();
        Date date = new Date();
        if(titre.equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "le Titre est obligatoire \n s'il vous plait vérifier vos données!!!", duration);
            toast.show();
        }
        else
        {
            if(ad.equals(""))
            {
                Toast toast = Toast.makeText(getApplicationContext(), "l'adresse est obligatoire \n s'il vous plait vérifier vos données !!! ", duration);
                toast.show();
            }
            else
            {
                if(hD.equals(""))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Heure Début est obligatoire \n s'il vous plait vérifier vos données !!! ", duration);
                    toast.show();
                }
                else
                {
                    if(hF.equals(""))
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Heure Fin est obligatoire \n s'il vous plait vérifier vos données !!! ", duration);
                        toast.show();
                    }
                    else
                    {
                        if(desp.equals(""))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(), "Déscription est obligatoire \n s'il vous plait vérifier vos données !!! ", duration);
                            toast.show();
                        }
                        else
                        {
                            if(dConf.equals(""))
                            {
                                Toast toast = Toast.makeText(getApplicationContext(), "Date de Conférence  est obligatoire \n s'il vous plait vérifier vos données !!! ", duration);
                                toast.show();
                            }
                            else {
                                try {
                                    heureDebut = simple.parse(hD);
                                    heureFin = simple.parse(hF);
                                    date = sdf.parse(dConf);
                                    //inerstion
                                    DatabaseOperations databaseOperations = new DatabaseOperations(this);
                                    SQ = databaseOperations.getWritableDatabase();
                                    databaseOperations.addConference(SQ, titre, ad, dConf, hD, hF, desp, form);
                                    Toast toast = Toast.makeText(getApplicationContext(), "l'ajout d'une Conférence faite avec succès", duration);
                                    toast.show();

                                    Intent intent = new Intent(this, MyConferences.class);
                                    intent.putExtra("ps",ps);
                                    startActivity(intent);
                                } catch (ParseException e) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "S'il vous plait vérifier vos la date et/ou l' heure !!! ", duration);
                                    toast.show();
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

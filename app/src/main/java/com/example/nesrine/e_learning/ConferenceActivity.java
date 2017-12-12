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

public class ConferenceActivity extends AppCompatActivity {
    String code;
    String titre, descp,adr, date, hD, hF, ps;
    EditText titr, adresse, dateConf, heurD, heurF,desc;
    Button updateB, commB;
    String tit, ad, dConf, hd, hf, desp, form;
    int duration = Toast.LENGTH_LONG;
    SQLiteDatabase SQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        //recupéer les données à partir d'activity my conference
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
        code = intent.getStringExtra("code");
        titre = intent.getStringExtra("titre");
        adr = intent.getStringExtra("adr");
        date = intent.getStringExtra("date");
        hD = intent.getStringExtra("hD");
        hF = intent.getStringExtra("hF");
        descp= intent.getStringExtra("descp");
        //lie les elements du java avec xml
        titr = (EditText)findViewById(R.id.t1);
        adresse = (EditText)findViewById(R.id.t2);
        dateConf = (EditText)findViewById(R.id.t3);
        heurD = (EditText)findViewById(R.id.t4);
        heurF = (EditText)findViewById(R.id.t5);
        desc = (EditText)findViewById(R.id.t6);
        updateB = (Button)findViewById(R.id.updateB);
        commB =(Button)findViewById(R.id.commencerB);
        //remplir les EditText
        titr.setText(titre);
        adresse.setText(adr);
        dateConf.setText(date);
        heurD.setText(hD);
        heurF.setText(hF);
        desc.setText(descp);
    }
    public void  updateConfer(View view)
    {
        titre= titr.getText().toString();
        ad = adresse.getText().toString();
        dConf = dateConf.getText().toString();
        hD = heurD.getText().toString();
        hF = heurF.getText().toString();
        desp = desc.getText().toString();
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
                                    //Update
                                    DatabaseOperations databaseOperations = new DatabaseOperations(this);
                                    SQ = databaseOperations.getWritableDatabase();
                                    databaseOperations.updateConference(SQ,code, titre, ad, dConf, hD, hF, desp, ps);
                                    Toast toast = Toast.makeText(getApplicationContext(), "Conférence éte modifier ", duration);
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
     public void commencerConf(View view)
     {
         Toast toast = Toast.makeText(getApplicationContext(), "conférence direct ^-^ ", duration);
         toast.show();
     }
}

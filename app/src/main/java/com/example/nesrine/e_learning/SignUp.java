package com.example.nesrine.e_learning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button login, sign, inscrir;
    EditText nom, prenom, pseudo, motpass, motcof, email;
    RadioButton form, etud;
    int duration = Toast.LENGTH_SHORT;
    String  name, lastn, pse, mot,motc, ema,user;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=(Button)findViewById(R.id.loginB);
        sign =(Button)findViewById(R.id.signupB);
        nom = (EditText)findViewById(R.id.t1);
        prenom =(EditText)findViewById(R.id.t2);
        pseudo =(EditText)findViewById(R.id.t3);
        email = (EditText)findViewById(R.id.t4);
        motpass =(EditText) findViewById(R.id.t5);
        motcof =(EditText)findViewById(R.id.t6);
        form= (RadioButton) findViewById(R.id.radioetud);
        etud= (RadioButton) findViewById(R.id.radiofor);
        inscrir =(Button)findViewById(R.id.inscB);
    }
    //Methode navigation  Button sigup
    public void gotosign(View view)
    {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
    //Methode navigation  Button Login
    public void gotologin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //OnClick methode for inscrir Button
    public void inscrir(View view)
    {
        //recupérer les données
        name = nom.getText().toString();
        Log.d("name ",name);
        lastn = prenom.getText().toString();
        pse = pseudo.getText().toString();
        mot = motpass.getText().toString();
        motc = motcof.getText().toString();
        ema = email.getText().toString();

        if(name.equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Nom est obligatoire ", duration);
            toast.show();
        }
        else
        {
            if (lastn.equals(""))
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Prenom est obligatoire ", duration);
                toast.show();
            }
            else
            {
                if (pse.equals(""))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Pseudo est obligatoire ", duration);
                    toast.show();
                }
                else
                {
                    if (ema.equals(""))
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "email est obligatoire ", duration);
                        toast.show();
                    }
                    else
                    {
                        if (mot.equals(""))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(), "Mot de passe est obligatoire ", duration);
                            toast.show();
                        }
                        else
                        {
                            if (motc.equals(""))
                            {
                                Toast toast = Toast.makeText(getApplicationContext(), "La confirmation de mot de passe  est obligatoire ", duration);
                                toast.show();
                            }
                            else
                            {  //test RadioButton
                                if (!(form.isChecked()||etud.isChecked()))
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Le choix du type  est obligatoire ", duration);
                                    toast.show();
                                }
                                else
                                {

                                    if (!(motc.equals(mot)))
                                    {
                                        Toast toast = Toast.makeText(getApplicationContext(), "Les deux mot de passe ne sont pas identique verifiez votre données ", duration);
                                        toast.show();
                                        motcof.setText("");
                                    }
                                    else
                                    {
                                      //Donner un value ou user
                                        if(form.isChecked())
                                        {
                                            user = form.getText().toString();
                                        }
                                        else
                                        {
                                            user = etud.getText().toString();
                                        }
                                                // insert
                                        DatabaseOperations databaseOperations = new DatabaseOperations(this);
                                        databaseOperations.putInformation(databaseOperations,name,lastn,pse,ema,mot,user);
                                        Toast toast = Toast.makeText(getApplicationContext(), "Inscription faite avec succées", duration);
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
}

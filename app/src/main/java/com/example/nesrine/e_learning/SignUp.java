package com.example.nesrine.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignUp extends AppCompatActivity {
    Button login, sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=(Button)findViewById(R.id.loginB);
        sign =(Button)findViewById(R.id.signupB);
    }
    //Methode navigation  Button sigup
    public void gotosign(View view)
    {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
    //Methode navigation  Button Login
    public void gotologin(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
    }
}

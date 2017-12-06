package com.example.nesrine.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, sign, forget, connect;
    ImageButton eye;
    EditText pseudo, password;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.loginB);
        sign =(Button)findViewById(R.id.signupB);
        eye =(ImageButton)findViewById(R.id.eyeB);
        connect = (Button)findViewById(R.id.cx);
        pseudo = (EditText)findViewById(R.id.edit1);
        password = (EditText)findViewById(R.id.edit2);
        textView = (TextView)findViewById(R.id.textView);
        forget =(Button)findViewById(R.id.forgetB);
        //Methode for visibality of the password
        eye.setOnClickListener(new View.OnClickListener()
                               {

                                   @Override
                                   public void onClick(View v) {
                                       String motPass;
                                       int duration = Toast.LENGTH_SHORT;
                                       motPass = password.getText().toString();
                                       Toast toast = Toast.makeText(getApplicationContext(), motPass, duration);
                                       toast.show();
                                   }
                               }
        );

    }
    //Methode navigation  Button sigup
    public void gotosign(View view)
    {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
    //Methode navigation  Button Login
    public void gotosame(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

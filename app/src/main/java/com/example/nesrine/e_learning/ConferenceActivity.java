package com.example.nesrine.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConferenceActivity extends AppCompatActivity {
    String code;
    String titre, descp,adr, date, hD, hF, ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
        code = intent.getStringExtra("code");
        titre = intent.getStringExtra("titre");
        adr = intent.getStringExtra("adr");
        date = intent.getStringExtra("date");
        hD = intent.getStringExtra("hD");
        hF = intent.getStringExtra("hF");
        descp= intent.getStringExtra("descp");
    }
}

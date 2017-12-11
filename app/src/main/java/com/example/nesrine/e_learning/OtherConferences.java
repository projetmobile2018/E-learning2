package com.example.nesrine.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OtherConferences extends AppCompatActivity {
    String ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_conferences);
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
    }
}

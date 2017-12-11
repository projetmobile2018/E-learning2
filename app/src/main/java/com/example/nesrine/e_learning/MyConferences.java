package com.example.nesrine.e_learning;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MyConferences extends AppCompatActivity {
DatabaseOperations dop = new DatabaseOperations(this);
    Cursor cr;
    String code;
    String titre, descp,adr, form, date, hD, hF;
    MainActivity mainActivity = new MainActivity();
    String ps;
    ListView list;
    SQLiteDatabase sqLiteDatabase;
    ConferenceAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_conferences);
        list= (ListView)findViewById(R.id.list);
        listDataAdapter = new ConferenceAdapter(getApplicationContext(),R.layout.display_conference);
        list.setAdapter(listDataAdapter);
        dop = new DatabaseOperations(this);
        sqLiteDatabase = dop.getReadableDatabase();
        ps = mainActivity.getPs();
        cr = dop.getConfer(sqLiteDatabase);
        while(cr.moveToNext())
        {
            code = cr.getString(0);
            titre = cr.getString(1);
            adr = cr.getString(2);
            date = cr.getString(3);
            hD = cr.getString(4);
            hF = cr.getString(5);
            descp = cr.getString(6);
            form = cr.getString(7);
            /*if(form.equals(ps)) {
                Conference cf = new Conference(code, titre, descp, form, hD, hF, date, adr);


            }*/
            Conference cf = new Conference(code, titre, descp, form, hD, hF, date, adr);
            listDataAdapter.add(cf);
        }
    }
}

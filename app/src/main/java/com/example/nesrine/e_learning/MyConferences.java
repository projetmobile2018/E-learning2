package com.example.nesrine.e_learning;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

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
    ArrayList<Conference> listC = new ArrayList<>();
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_conferences);
        Intent intent = getIntent();
        ps = intent.getStringExtra("ps");
        list= (ListView)findViewById(R.id.list);
        listDataAdapter = new ConferenceAdapter(getApplicationContext(),R.layout.display_conference);
        list.setAdapter(listDataAdapter);
        dop = new DatabaseOperations(this);
        sqLiteDatabase = dop.getReadableDatabase();
        ps = mainActivity.getPs();
        cr = dop.getConfer(sqLiteDatabase);
        if(cr.moveToFirst()) {
            do {
                code = cr.getString(0);
                titre = cr.getString(1);
                adr = cr.getString(2);
                date = cr.getString(3);
                hD = cr.getString(4);
                hF = cr.getString(5);
                descp = cr.getString(6);
                form = cr.getString(7);

                    Conference cf = new Conference(code, titre, descp, form, hD, hF, date, adr);
               listC.add(cf);


            } while (cr.moveToNext());
            Toast.makeText(MyConferences.this, "ps "+ps, Toast.LENGTH_LONG).show();
            //supprimer les conferneces des autre formateur
            Toast.makeText(MyConferences.this, "view "+listC.get(i).getForm_ref(), Toast.LENGTH_LONG).show();
            while(i<listC.size())
            {
                String f = listC.get(i).getForm_ref();
                /*Toast.makeText(MyConferences.this, "view "+f, Toast.LENGTH_LONG).show();
                if (ps.equals(f))
                    i++;
                else
                {
                    listC.remove(i);
                }
                */

            }
            //afficher la liste dans ListView
            for(int i=0;i<listC.size();i++) {
                listDataAdapter.add(listC.get(i));
            }

        }
        //Onclik for
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyConferences.this, "view "+view, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),ConferenceActivity.class);
                intent.putExtra("ps",ps);
                intent.putExtra("code", code);
                intent.putExtra("titre",titre);
                intent.putExtra("adr",adr);
                intent.putExtra("date", date);
                intent.putExtra("hD",hD);
                intent.putExtra("hF",hF);
                intent.putExtra("descp",descp);
                startActivity(intent);

            }
        });
    }
}

package com.example.nesrine.e_learning;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nesrine on 06/12/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version =1;
    //query for Table Admin
    public String CREATE_QUERY_admin="CREATE TABLE "+ TableData.TableInfo.table_admin+" ( "+ TableData.TableInfo.pseudo_admin+" TEXT PRIMARY KEY,"+ TableData.TableInfo.mot_passe+" TEXT);";
    //query for table formateur
    public String CREATE_QUERY_form="CREATE TABLE "+ TableData.TableInfo.table_forma+" ( "+ TableData.TableInfo.pseudo_form+" TEXT PRIMARY KEY,"+ TableData.TableInfo.mot_pass_form+" TEXT, "+ TableData.TableInfo.nom_form+" TEXT , "+ TableData.TableInfo.prenom_form+" TEXT,"+ TableData.TableInfo.email_form+" TEXT UNIQUE);";
    //query for table etudiant
    public String CREATE_QUERY_etud="CREATE TABLE "+ TableData.TableInfo.table_etud+" ( "+ TableData.TableInfo.pseudo_etud+" TEXT PRIMARY KEY,"+ TableData.TableInfo.mot_pass_etud+" TEXT, "+ TableData.TableInfo.nom_etud+" TEXT , "+ TableData.TableInfo.prenom_etud+" TEXT,"+ TableData.TableInfo.email_etud+" TEXT UNIQUE);";
    //query for table conférence
    public String CREATE_QUERY_conf ="CREATE TABLE "+ TableData.TableInfo.table_conf+" ( "+ TableData.TableInfo.code_conf+" INTEGER PRIMARY KEY AUTOINCREMENT , "+ TableData.TableInfo.titre+" TEXT, "+ TableData.TableInfo.adresse+" TEXT, "+ TableData.TableInfo.date_conf+" TEXT , "+ TableData.TableInfo.heure_deb+" TEXT , "+ TableData.TableInfo.heure_fin+" TEXT,"+ TableData.TableInfo.descrip+" TEXT, "+ TableData.TableInfo.form_ref+" TEXT, FOREIGN KEY ("+ TableData.TableInfo.form_ref+ ") REFERENCES "+ TableData.TableInfo.table_forma+"("+ TableData.TableInfo.pseudo_form+"));";
    //query for table participation
    public String CREATE_QUERY_PART= "CREATE TABLE "+ TableData.TableInfo.table_part+" ( "+ TableData.TableInfo.date_part+" TEXT , "+ TableData.TableInfo.etud+" TEXT,"+ TableData.TableInfo.conf+" INT, PRIMARY KEY("+TableData.TableInfo.date_part+","+TableData.TableInfo.etud+","+TableData.TableInfo.conf+"), FOREIGN KEY ("+TableData.TableInfo.etud+") REFERENCES "+ TableData.TableInfo.table_etud+" ("+ TableData.TableInfo.pseudo_etud+"), FOREIGN KEY ("+TableData.TableInfo.conf+") REFERENCES "+ TableData.TableInfo.table_conf+"("+ TableData.TableInfo.code_conf+"));";
    //Creation DATABASE
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.Data_Base_Name, null, database_version);
        Log.d("Database oprerations", "Database created OR OPEN");
    }
    //CRATION DES TABLES
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY_admin);
        Log.d("Table administrateur","administrateur has been created ");
        db.execSQL(CREATE_QUERY_form);
        Log.d("Table formateur","formateur has been created ");
        db.execSQL(CREATE_QUERY_etud);
        Log.d("Table etudiant","ETUDIANT has been created ");
        db.execSQL(CREATE_QUERY_conf);
        Log.d("Table conférence","conférence has been created ");
        db.execSQL(CREATE_QUERY_PART);
        Log.d("Table participation","participation has been created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //Insert Formateur ou Etudiant
    public void putInformation(SQLiteDatabase SQ, String nom, String prenom, String pseudo,String email, String motPass, String user)
    {
        ContentValues cv = new ContentValues();
        if(user.equals("formateur"))
        {
            cv.put(TableData.TableInfo.pseudo_form,pseudo);
            cv.put(TableData.TableInfo.mot_pass_form, motPass);
            cv.put(TableData.TableInfo.nom_form, nom);
            cv.put(TableData.TableInfo.prenom_form, prenom);
            cv.put(TableData.TableInfo.email_form,email);
            long k = SQ.insert(TableData.TableInfo.table_forma,null, cv);

            Log.d("DATABASE OPRETIONS ","One Formateur inserted "+k);
        }
        else
        {
            cv.put(TableData.TableInfo.pseudo_etud,pseudo);
            cv.put(TableData.TableInfo.mot_pass_etud, motPass);
            cv.put(TableData.TableInfo.nom_etud, nom);
            cv.put(TableData.TableInfo.prenom_etud, prenom);
            cv.put(TableData.TableInfo.email_etud,email);
            long k = SQ.insert(TableData.TableInfo.table_etud,null, cv);
            Log.d("DATABASE OPRETIONS ","One Etudiant inserted "+k);
        }

    }
    //Insert Admin
    public void putAdmin(DatabaseOperations dop, String pseudo, String motPass) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.pseudo_admin , pseudo);
        cv.put(TableData.TableInfo.mot_passe, motPass);
        long k = SQ.insert(TableData.TableInfo.table_admin,null, cv);
        Log.d("DATABASE OPRETIONS ","One Admin inserted");
    }
    public Cursor getForm(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();

        String[] list = {TableData.TableInfo.pseudo_form, TableData.TableInfo.mot_pass_form, TableData.TableInfo.nom_form, TableData.TableInfo.prenom_form, TableData.TableInfo.email_form};
        Cursor CR = SQ.query(TableData.TableInfo.table_forma,list,null,null,null,null,null,null);
        return CR;
    }
    public void  addConference(SQLiteDatabase SQ, String titre, String adresse, String dateConf, String heurD, String heurF,String descp, String form)
    {

        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.titre,titre);
        cv.put(TableData.TableInfo.adresse, adresse);
        cv.put(TableData.TableInfo.date_conf,dateConf);
        cv.put(TableData.TableInfo.heure_deb,heurD);
        cv.put(TableData.TableInfo.heure_fin,heurF);
        cv.put(TableData.TableInfo.descrip, descp);
        cv.put(TableData.TableInfo.form_ref, form);
        long k = SQ.insert(TableData.TableInfo.table_conf,null, cv);
        Log.d("DATABASE OPRETIONS ","One CONFERENCE inserted");
    }
    public Cursor getConfer(SQLiteDatabase SQ)
    {
            String[] conferneces ={TableData.TableInfo.code_conf, TableData.TableInfo.titre, TableData.TableInfo.adresse, TableData.TableInfo.date_conf, TableData.TableInfo.heure_deb, TableData.TableInfo.heure_fin, TableData.TableInfo.descrip, TableData.TableInfo.form_ref};
            Cursor CR = SQ.query(TableData.TableInfo.table_conf,conferneces,null,null,null,null,null,null);
            return CR;

    }
}

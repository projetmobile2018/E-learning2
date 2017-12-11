package com.example.nesrine.e_learning;

import android.provider.BaseColumns;

/**
 * Created by Nesrine on 06/12/2017.
 */

public class TableData {
    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        //les information sur les diff tables, les columns, data base name...
        // table Admin
        public static final String table_admin="ADMINISTRATEUR";
        public static final String pseudo_admin="PSEUDO_ADMIN";
        public static final String  mot_passe ="MOT_PASS_ADMIN";
        //table Formateur
        public static final String table_forma="FORMATEUR";
        public static  final String pseudo_form ="PSEUDO_FORM";
        public static  final String mot_pass_form="MOT_PASS_FORM";
        public static  final String nom_form="NOM_FORM";
        public static  final String prenom_form="PRENOM_FORM";
        public static  final String email_form ="EMAIL_FORM";
        //table Formateur
        public static final String table_etud="ETUDIANT";
        public static  final String pseudo_etud ="PSEUDO_ETUD";
        public static  final String mot_pass_etud="MOT_PASS_ETUD";
        public static  final String nom_etud="NOM_ETUD";
        public static  final String prenom_etud="PRENOM_ETUD";
        public static  final String email_etud ="EMAIL_ETUD";
        //table conference
        public static final String table_conf="CONFERENCE";
        public static final String code_conf="CODE_CONF";
        public static  final String titre ="TITRE";
        public static  final String adresse ="ADRESSE";
        public static  final String date_conf ="DATE_CONF";
        public static  final String heure_deb="HEURE_DEB";
        public static  final String heure_fin="HEURE_FIN";
        public static  final String descrip="DESCRIP";
        public static  final String form_ref="FORM_REF";//Cle étranger de table FORMATEUR
        //Table participation=> relation entre Etudiant et Conférence car un etudiant peut participer à 0 ou * conference au date diff et une conférence peut contient 0 à * etudiant au date diff
        public static final String table_part="PARTICIPATION";
        public static final String date_part="DATE_PART";
        public static final String etud ="ETUD";
        public static final String conf="CONF";
        //DATA BASE
        public static  final String Data_Base_Name="DB_E-learning";

    }
}

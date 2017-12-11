package com.example.nesrine.e_learning;

import java.util.Date;

/**
 * Created by Nesrine on 10/12/2017.
 */

public class Conference {
    private String code_conf;
    private String titre, description, form_ref;
    private String heureD,heureF, dateConf, adresse;

    public Conference(String  code_conf, String titre, String description, String form_ref, String heureD, String heureF, String dateConf, String ad) {
        this.code_conf = code_conf;
        this.titre = titre;
        this.description = description;
        this.form_ref = form_ref;
        this.heureD = heureD;
        this.heureF = heureF;
        this.dateConf = dateConf;
        this.adresse = ad;
    }

    public String  getCode_conf() {
        return code_conf;
    }

    public void setCode_conf(String  code_conf) {
        this.code_conf = code_conf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForm_ref() {
        return form_ref;
    }

    public void setForm_ref(String form_ref) {
        this.form_ref = form_ref;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureF() {
        return heureF;
    }

    public void setHeureF(String heureF) {
        this.heureF = heureF;
    }

    public String getDateConf() {
        return dateConf;
    }

    public void setDateConf(String dateConf) {
        this.dateConf = dateConf;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}

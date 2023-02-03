package com.ummeeth.speedquizz;

import android.database.Cursor;

public class Question {

    private String intitule;
    private int reponse;

    public Question(String intitule, int reponse) {
        this.intitule = intitule;
        this.reponse = reponse;
    }

    public Question(Cursor cursor) {
        intitule = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));

    }

    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getReponse() {
        return reponse;
    }
    public void setReponse(int reponse) {
        this.reponse = reponse;
    }
}

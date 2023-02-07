package com.ummeeth.speedquizz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpeedQuizzSqlite extends SQLiteOpenHelper {

    static String DB_NAME ="THE_SpeedQuizz.dp";
    static int DB_VERSION =1;

    public SpeedQuizzSqlite(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreateDataTable = "CREATE TABLE Question (idQuizz INTEGER PRIMARY KEY,question TEXT,reponse BOOLEAN)";
        sqLiteDatabase.execSQL(sqlCreateDataTable);
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Il y a plus de 10 milliards de personnes sur Terre\", 1)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Nous tournons autour du soleil\", 0)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Raval est génial:]\", 0)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Rouge et bleu donne vert\", 1)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Le clavier qwertz est suisse\", 0)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"Superficie de la Terre : 510'067'420km²\", 0)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"La terre est plate\", 1)");
        sqLiteDatabase.execSQL("INSERT INTO Question VALUES (null,\"N'appuis pas    (°ー°〃)\", 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersoin, int newVersion) {

    }
}

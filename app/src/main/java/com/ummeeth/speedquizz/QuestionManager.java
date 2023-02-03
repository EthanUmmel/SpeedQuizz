package com.ummeeth.speedquizz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {

    private List<Question> questionList;

    public QuestionManager(Context context) {
        questionList = initQuestionList(context);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    private ArrayList<Question> initQuestionList(Context context) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        SpeedQuizzSqlite helper = new SpeedQuizzSqlite(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(true,"Question",new String[]{"idQuizz","question","reponse"},null,null,null,null,"idQuizz",null);

        while(cursor.moveToNext()) {
            listQuestion.add(new Question(cursor));
        }
        cursor.close();
        db.close();

        return listQuestion;
    }
}

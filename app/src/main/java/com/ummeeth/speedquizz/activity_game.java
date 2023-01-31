package com.ummeeth.speedquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_game extends AppCompatActivity {

    Runnable questionRunnable = null;
    Handler handler;
    private TextView textQuestionJ1;
    private TextView textQuestionJ2;
    private TextView timerJ1;
    private TextView timerJ2;

    ArrayList<Question> listeQuestion = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent activity_game = getIntent();

        TextView nomJoueur1 = findViewById(R.id.PseudoJ1);
        TextView nomJoueur2 = findViewById(R.id.PseudoJ2);
        textQuestionJ1 = findViewById(R.id.questionJ1);
        textQuestionJ2 = findViewById(R.id.questionJ2);
        timerJ1 = findViewById(R.id.timerJ1);
        timerJ2 = findViewById(R.id.timerJ2);

        nomJoueur1.setText(activity_game.getStringExtra("NomJoueur1"));
        nomJoueur2.setText(activity_game.getStringExtra("NomJoueur2"));

        Question question1 = new Question("Il y a plus de 10 milliards de personnes sur Terre", false);
        Question question2 = new Question("Nous tournons autour du soleil", true);

        listeQuestion.add(question1);
        listeQuestion.add(question2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startCountDownTimer();
        startQuestionIterative();
    }



    private void startQuestionIterative() {
        handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                int indexQuestion = 0;
                Question questionActuel = listeQuestion.get(indexQuestion);
                listeQuestion.remove(indexQuestion);

                textQuestionJ1.setText(questionActuel.getIntitule());
                textQuestionJ2.setText(questionActuel.getIntitule());

                //Détecter si c'est la dernière question
                if (listeQuestion.isEmpty()){
                    //Do last question process
                    System.out.println("Hello");
                }else{
                    //Do question iterative

                    handler.postDelayed(this, 2000);
                }
            }
        };

        handler.postDelayed(questionRunnable, 1000);

    }

    private void startCountDownTimer() {
        new CountDownTimer(3000, 1000){
            public void onTick(long millisUntilFinished){
                String decompte = String.valueOf(millisUntilFinished/1000);
                timerJ1.setText(decompte);
                timerJ2.setText(decompte);
            }

            public void onFinish(){
                timerJ1.setText(getText(R.string.timer));
                timerJ2.setText(getText(R.string.timer));
            }

        }.start();
    }




}
package com.ummeeth.speedquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

public class activity_game extends AppCompatActivity {

    Runnable questionRunnable = null;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView nomJoueur1 = findViewById(R.id.PseudoJ1);
        TextView nomJoueur2 = findViewById(R.id.PseudoJ2);

    }

    private void startQuestionIterative() {
        handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                //Détecter si c'est la dernière question
                //if (){
                    //Do last question process
                //}else{
                    //Do question iterative
                //    handler.postDelayed(this, 2000);
                //}
            }
        };

        handler.postDelayed(questionRunnable, 1000);

    }




    private void startCountDownTimer() {
        new CountDownTimer(3000, 1000){
            public void onTick(long millisUntilFinished){
                //XXX.setText(""+millisUntilFinished / 1000);
            };
            public void onFinish(){
                //XXX.setText(getText(R.string.XXX));
            };

        }.start();
    }




}
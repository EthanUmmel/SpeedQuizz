package com.ummeeth.speedquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ET_nomJoueur1;
    private EditText ET_nomJoueur2;
    private Button BT_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_nomJoueur1 = findViewById(R.id.main_J1_et);
        ET_nomJoueur2 = findViewById(R.id.main_J2_et);
        BT_Start = findViewById(R.id.main_start_bt);

        ET_nomJoueur2.setVisibility(View.GONE);
        BT_Start.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ET_nomJoueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!ET_nomJoueur1.getText().toString().isEmpty()) {
                    ET_nomJoueur2.setVisibility(View.VISIBLE);
                } else {
                    ET_nomJoueur2.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        ET_nomJoueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!ET_nomJoueur2.getText().toString().isEmpty()) {
                    BT_Start.setVisibility(View.VISIBLE);
                } else {
                    BT_Start.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        BT_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomJ1 = ET_nomJoueur1.getText().toString();
                String nomJ2 = ET_nomJoueur2.getText().toString();

                Intent activity_game = new Intent(MainActivity.this, activity_game.class);
                activity_game.putExtra("NomJoueur1", nomJ1);
                activity_game.putExtra("NomJoueur2", nomJ2);
                startActivity(activity_game);
            }
        });



    }
}
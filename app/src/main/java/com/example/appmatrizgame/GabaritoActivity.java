package com.example.appmatrizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GabaritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gabarito);

        Button btnVoltarQuiz = findViewById(R.id.btnVoltarQuiz);
        btnVoltarQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(GabaritoActivity.this, QuizMatrizActivity.class);
            startActivity(intent);
        });

        Button btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(view -> {
            Intent intent = new Intent(GabaritoActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }


}

package com.example.appmatrizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AprenderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        Button btnPularParaQuiz = findViewById(R.id.btnPularParaQuiz);
        btnPularParaQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(AprenderActivity.this, QuizMatrizActivity.class );
            startActivity(intent);
        });

        Button btnProsseguir = findViewById(R.id.btnProsseguir);
        btnProsseguir.setOnClickListener(view -> {
            Intent intent = new Intent(AprenderActivity.this, AprenderFinalActivity.class);
            startActivity(intent);
        });
        return;
    }


}

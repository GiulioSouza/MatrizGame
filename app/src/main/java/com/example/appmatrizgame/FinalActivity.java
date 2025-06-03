package com.example.appmatrizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Button btnEnfrentarQuiz = findViewById(R.id.btnEnfrentarQuiz);
        Button btnFecharJogo = findViewById(R.id.btnFecharJogo);

        btnEnfrentarQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(FinalActivity.this, QuizMatrizActivity.class);
            startActivity(intent);
        });

        btnFecharJogo.setOnClickListener(view -> {
            finishAffinity();
            System.exit(0);
        });
        return;
    }
}

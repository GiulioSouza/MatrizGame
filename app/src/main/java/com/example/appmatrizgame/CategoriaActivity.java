package com.example.appmatrizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CategoriaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_categoria);

        Button btnAprender = findViewById(R.id.btnAprender);
        btnAprender.setOnClickListener(view -> {
            Intent intent = new Intent(CategoriaActivity.this, AprenderActivity.class);
            startActivity(intent);
        });

        Button btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(CategoriaActivity.this, QuizMatrizActivity.class);
            startActivity(intent);
        });
    }
}

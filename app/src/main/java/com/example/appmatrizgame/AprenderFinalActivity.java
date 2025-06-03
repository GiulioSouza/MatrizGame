package com.example.appmatrizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AprenderFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender_final);

        Button btnConcluirJornada = findViewById(R.id.btnConcluirJornada);
        btnConcluirJornada.setOnClickListener(view -> {
            Intent intent = new Intent(AprenderFinalActivity.this, FinalActivity.class);
            startActivity(intent);
        });

        Button btnRevisarConteudo = findViewById(R.id.btnRevisarConteudo);
        btnRevisarConteudo.setOnClickListener(view -> {
            Intent intent = new Intent(AprenderFinalActivity.this, AprenderActivity.class);
            startActivity(intent);
        });
    }
}

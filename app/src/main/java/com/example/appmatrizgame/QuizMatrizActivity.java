package com.example.appmatrizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMatrizActivity extends AppCompatActivity {

    private List<String> respostasUsuario = new ArrayList<>();
    private List<String> respostasCorretas = Arrays.asList("a", "c", "d", "a", "b");
    private int contagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_matriz);

        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        RadioGroup radioGroup5 = findViewById(R.id.radioGroup5);
        Button btnFinalizar = findViewById(R.id.btnVoltarQuiz);
        Button btnRecomecar = findViewById(R.id.btnInicio);
        Button btnVerGabarito = findViewById(R.id.btnVerGabarito);
        Button btnFecharJogo = findViewById(R.id.btnFecharJogo);
        Button btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        btnFinalizar.setOnClickListener(view -> {
            contagem++;
            if(contagem >= 3) {
                btnVerGabarito.setVisibility(View.VISIBLE);
            }
            respostasUsuario.add(pegarOpcoesSelecionadas(radioGroup1));
            respostasUsuario.add(pegarOpcoesSelecionadas(radioGroup2));
            respostasUsuario.add(pegarOpcoesSelecionadas(radioGroup3));
            respostasUsuario.add(pegarOpcoesSelecionadas(radioGroup4));
            respostasUsuario.add(pegarOpcoesSelecionadas(radioGroup5));

            if(respostasUsuario.equals(respostasCorretas)) {
                TextView resultMessage = findViewById(R.id.resultMessage);
                resultMessage.setText("Parabéns, você acertou tudo.");
                resultMessage.setVisibility(View.VISIBLE);

                btnVerGabarito.setVisibility(View.VISIBLE);

                return;
            }

            calcularPontuacao();
        });

        btnRecomecar.setOnClickListener(view -> {
            radioGroup1.clearCheck();
            radioGroup2.clearCheck();
            radioGroup3.clearCheck();
            radioGroup4.clearCheck();
            radioGroup5.clearCheck();

            respostasUsuario.clear();

            TextView resultMessage = findViewById(R.id.resultMessage);
            resultMessage.setVisibility(View.INVISIBLE);
            btnVerGabarito.setVisibility(View.INVISIBLE);

        });

        btnVerGabarito.setOnClickListener(view -> {
            Intent intent = new Intent(QuizMatrizActivity.this, GabaritoActivity.class);
            startActivity(intent);
        });

        btnFecharJogo.setOnClickListener(view -> {
            finishAffinity();
            System.exit(0);
        });

        btnVoltarInicio.setOnClickListener(view -> {
            Intent intent = new Intent(QuizMatrizActivity.this, MainActivity.class);
            startActivity(intent);
        });
        return;
    }


    private String pegarOpcoesSelecionadas(RadioGroup radioGroup) {
        int idSelecionado = radioGroup.getCheckedRadioButtonId();
        if(idSelecionado != -1) {
            RadioButton btnSelecionado = findViewById(idSelecionado);
            return btnSelecionado.getTag().toString();
        }
        return "";
    }

    private void calcularPontuacao() {
        int score = 0;
        for(int i = 0;i < respostasCorretas.size(); i++ ) {
            if(respostasUsuario.size() > i && respostasUsuario.get(i).equals(respostasCorretas.get(i))) {
                score ++;
            }
        }

        TextView resultMessage = findViewById(R.id.resultMessage);
        resultMessage.setText("Você acertou " + score + " de " + respostasCorretas.size());
        resultMessage.setVisibility(View.VISIBLE);
    }
}

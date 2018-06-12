package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaCalculoNotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculo_notas);
    }

    public void novanotaexame(View view){
        startActivity(new Intent(TelaCalculoNotas.this, NovaNotaExame.class));

    }

    public void novanotatrimestre(View view){
        startActivity(new Intent(TelaCalculoNotas.this, NovaNotaTrimestre.class));

    }

}

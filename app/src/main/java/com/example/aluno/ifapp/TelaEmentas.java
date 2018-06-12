package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaEmentas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ementas);


    }

    public void botaoinfo(View view){
        startActivity(new Intent(TelaEmentas.this, EmentasInfo.class));
    }

    public void botaoadm (View view){
        startActivity(new Intent(TelaEmentas.this, EmentasAdm.class));
    }

    public void botaovest(View view){
        startActivity(new Intent(TelaEmentas.this, EmentasVest.class));
    }

    public void botaoem(View view){
        startActivity(new Intent(TelaEmentas.this, EmentasEM.class));
    }

}

package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmentasEM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementas_em);
    }

    public void em1ano(View view){
        startActivity(new Intent(EmentasEM.this, Em1Ano.class));
    }

    public void em2ano(View view){
        startActivity(new Intent(EmentasEM.this, Em2Ano.class));
    }

    public void em3ano(View view){
        startActivity(new Intent(EmentasEM.this, Em3Ano.class));
    }
}

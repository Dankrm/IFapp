package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmentasVest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementas_vest);
    }

    public void vest1ano(View view){
        startActivity(new Intent(EmentasVest.this, Vest1Ano.class));

    }

    public void vest2ano(View view){
        startActivity(new Intent(EmentasVest.this, Vest2Ano.class));

    }

    public void vest3ano(View view){
        startActivity(new Intent(EmentasVest.this, Vest3Ano.class));

    }
}

package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmentasAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementas_adm);
    }

    public void adm1ano(View view){
        startActivity(new Intent(EmentasAdm.this, Adm1Ano.class));

    }

    public void adm2ano(View view){
        startActivity(new Intent(EmentasAdm.this, Adm2Ano.class));

    }

    public void adm3ano(View view){
        startActivity(new Intent(EmentasAdm.this, Adm3Ano.class));

    }


}

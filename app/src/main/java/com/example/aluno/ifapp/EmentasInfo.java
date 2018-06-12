package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmentasInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementas_info);
    }

    public void info1ano(View view){
        startActivity(new Intent(EmentasInfo.this, Info1Ano.class));
    }

    public void info2ano(View view){
        startActivity(new Intent(EmentasInfo.this, Info2Ano.class));
    }

    public void info3ano(View view){
        startActivity(new Intent(EmentasInfo.this, Info3Ano.class));
    }

}

package com.example.aluno.ifapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NovaNotaExame extends AppCompatActivity {
     private double mediaTrimestre;
     private double mediaFinal;
     private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_nota_exame);

    }

    public void calculaNotaExame(View v){
        EditText nota1 = (EditText) findViewById(R.id.nota1exame);
        double priNota = Double.parseDouble(nota1.getText().toString());
        EditText nota2 = (EditText) findViewById(R.id.nota2exame);
        double segNota = Double.parseDouble(nota2.getText().toString());
        EditText nota3 = (EditText) findViewById(R.id.nota3exame);
        double terNota = Double.parseDouble(nota3.getText().toString());

        mediaTrimestre = ( (priNota + segNota + terNota) / 3 ) * 0.6;
        mediaFinal =  ((5 - mediaTrimestre) / 0.4) ;

        resultado = (TextView) findViewById(R.id.mediafinal);
        String mf = String.valueOf(mediaFinal).substring(0,3);
        resultado.setText(mf);
    }





}

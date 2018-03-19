package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //SPINNER DO CURSO
        Spinner curso = (Spinner) findViewById(R.id.spCurso);
        ArrayAdapter adapterCurso = ArrayAdapter.createFromResource(this, R.array.curso, android.R.layout.simple_spinner_dropdown_item);
        curso.setAdapter(adapterCurso);

        //SPINNER DO ANO
        Spinner ano = (Spinner) findViewById(R.id.spAno);
        ArrayAdapter adapterAno = ArrayAdapter.createFromResource(this, R.array.ano, android.R.layout.simple_spinner_dropdown_item);
        ano.setAdapter(adapterAno);
    }
    public void botaocomecar(View view) {
        startActivity(new Intent(TelaPrincipal.this, MainActivity.class));
    }
}



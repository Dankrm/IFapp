package com.example.aluno.ifapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aluno.ifapp.databaseModel.AlunoDAO;
import com.example.aluno.ifapp.databaseModel.CursoDAO;
import com.example.aluno.ifapp.databaseModel.MainDatabase;

public class TelaPrincipal extends AppCompatActivity {
    private String cursoNome;
    private String anoCurso;
    private String nome;
    private EditText nomeAluno;
    private AlertDialog alerta;
    private MainDatabase db;
    private CursoDAO cursoDAO;
    private AlunoDAO alunoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        nomeAluno = (EditText) findViewById(R.id.nomeAluno);

        //SPINNER DO CURSO
        Spinner curso = (Spinner) findViewById(R.id.spCurso);
        ArrayAdapter<CharSequence> adapterCurso = ArrayAdapter.createFromResource(this, R.array.curso, android.R.layout.simple_spinner_item);
        adapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        curso.setAdapter(adapterCurso);


        //SPINNER DO ANO
        final Spinner ano = (Spinner) findViewById(R.id.spAno);
        ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(this, R.array.ano, android.R.layout.simple_spinner_item);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ano.setAdapter(adapterAno);


        curso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String curso = adapterView.getItemAtPosition(i).toString();
                cursoNome = curso;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String ano = adapterView.getItemAtPosition(i).toString();
                anoCurso = String.valueOf(ano.charAt(0));
                System.out.println(anoCurso);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void botaoVizualiza(View view) {
        nome = nomeAluno.getText().toString();
        String kkk = "Curso: "+cursoNome+"\nAno: "+anoCurso+"\nNome do Aluno: "+nome;
        Toast.makeText(getApplicationContext(), kkk, Toast.LENGTH_SHORT).show();

    }
    public void botaoComecar(View view){

        nome = nomeAluno.getText().toString();

        cursoDAO = new CursoDAO(getApplicationContext());
        alunoDAO = new AlunoDAO(getApplicationContext());

        Curso c = new Curso();
        c.setNome(cursoNome);
        c.setAno(Integer.parseInt(anoCurso));

        cursoDAO.inserir(c);

        Curso curso = cursoDAO.selecionaCursoPorId(2);
        System.out.println(curso.toString());


        alunoDAO.inserir(nome, curso);
        startActivity(new Intent(TelaPrincipal.this, MainActivity.class));


    }


}



package com.example.aluno.ifapp;

/**
 * Created by aluno on 19/03/18.
 */

public class Prova {
    private String data;
    private int nota;
    private Disciplina disciplina;

    public Prova() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}

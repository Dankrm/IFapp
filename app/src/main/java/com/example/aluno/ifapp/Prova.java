package com.example.aluno.ifapp;

import java.io.Serializable;

/**
 * Created by aluno on 19/03/18.
 */

public class Prova implements Serializable {
    private int pk_prova;
    private String data;
    private int nota;
    private Disciplina disciplina;

    public Prova() {

    }

    public Prova(int pk_prova, String data, int nota, Disciplina disciplina) {
        this.pk_prova = pk_prova;
        this.data = data;
        this.nota = nota;
        this.disciplina = disciplina;
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

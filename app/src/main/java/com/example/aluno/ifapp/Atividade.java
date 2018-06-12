package com.example.aluno.ifapp;

import java.io.Serializable;

/**
 * Created by aluno on 19/03/18.
 */

public class Atividade implements Serializable {
    private int pk_atividade;
    private String nome;
    private String dataEntrega;
    private int nota;
    private Disciplina disciplina;

    public Atividade() {

    }

    public Atividade(int pk_atividade, String nome, String dataEntrega, int nota, Disciplina disciplina) {
        this.pk_atividade = pk_atividade;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.nota = nota;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
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

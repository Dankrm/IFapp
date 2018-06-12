package com.example.aluno.ifapp;


import java.io.Serializable;

public class Aluno implements Serializable{
    private int pk_aluno;
    private String nome;
    private Curso curso;

    public Aluno() {

    }

    public Aluno(int pk_aluno, String nome, Curso curso) {
        this.pk_aluno = pk_aluno;
        this.nome = nome;
        this.curso = curso;
    }

    public int getPk_aluno() {
        return pk_aluno;
    }

    public void setPk_aluno(int pk_aluno) {
        this.pk_aluno = pk_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

package com.example.aluno.ifapp;

import java.io.Serializable;

public class Curso implements Serializable{
    private int pk_curso;
    private String nome;
    private int ano;
    private static Curso curso;

    public Curso() {

    }

    public Curso(int pk_curso, String nome, int ano) {
        this.pk_curso = pk_curso;
        this.nome = nome;
        this.ano = ano;
    }

    public int getPk_curso() {
        return pk_curso;
    }

    public void setPk_curso(int pk_curso){this.pk_curso = pk_curso;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "pk_curso=" + pk_curso +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                '}';
    }
}

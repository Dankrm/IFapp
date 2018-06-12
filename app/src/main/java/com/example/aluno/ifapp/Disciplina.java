package com.example.aluno.ifapp;

import java.io.Serializable;

/**
 * Created by léozin on 19/03/18.
 */

public class Disciplina implements Serializable {
    private String nome;
    private String ementa;
    private Curso curso;

    public Disciplina() {

    }

    public Disciplina(String nome, String ementa, Curso curso) {
        this.nome = nome;
        this.ementa = ementa;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", ementa='" + ementa + '\'' +
                ", curso=" + curso +
                '}';
    }
}

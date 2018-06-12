package com.example.aluno.ifapp;


import java.io.Serializable;

public class Anotacao implements Serializable {
    private int pk_aotacao;
    private String nome;
    private String descricao;
    private Atividade atividade;

    public Anotacao() {

    }

    public Anotacao(int pk_aotacao, String nome, String descricao, Atividade atividade) {
        this.pk_aotacao = pk_aotacao;
        this.nome = nome;
        this.descricao = descricao;
        this.atividade = atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}

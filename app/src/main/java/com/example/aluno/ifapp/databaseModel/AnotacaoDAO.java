package com.example.aluno.ifapp.databaseModel;

import android.content.Context;

import static com.example.aluno.ifapp.databaseModel.AtividadeDAO.*;


/**
 * Created by dangh on 26/05/2018.
 */

public class AnotacaoDAO {
    private MainDatabase db;


    public static final String ANOTACAO_TABELA = "anotacao";

    //ANOTACAO COLUNAS
    public static final String COL_1_ANOTACAO = "pk_anotacao";
    public static final String COL_2_ANOTACAO = "nome";
    public static final String COL_3_ANOTACAO = "descricao";
    public static final String COL_4_ANOTACAO = "fk_atividade";

    public static String dropTabelaAnotacao(){
        return "DROP TABLE "+ ANOTACAO_TABELA;
    }

    public static String criaTabelaAnotacao(){
        String CRIA_ANOTACAO = "CREATE TABLE " + ANOTACAO_TABELA
                + "(" + COL_1_ANOTACAO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2_ANOTACAO + " TEXT, "
                + COL_3_ANOTACAO + " TEXT, "
                + COL_4_ANOTACAO + " INTEGER NOT NULL,"
                + "FOREIGN KEY (" + COL_4_ANOTACAO + ") REFERENCES " + ATIVIDADE_TABELA + "(" + COL_1_ATIVIDADE + "));";
        return CRIA_ANOTACAO;
    }



    public AnotacaoDAO(Context ctx) {
        db = MainDatabase.getInstance(ctx);
    }
}

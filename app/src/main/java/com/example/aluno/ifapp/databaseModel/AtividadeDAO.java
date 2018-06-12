package com.example.aluno.ifapp.databaseModel;

import android.content.Context;

import static com.example.aluno.ifapp.databaseModel.DisciplinaDAO.*;

/**
 * Created by dangh on 26/05/2018.
 */

public class AtividadeDAO {
    private MainDatabase db;

    public AtividadeDAO(Context ctx) {
        db = MainDatabase.getInstance(ctx);
    }

    public static final String ATIVIDADE_TABELA = "atividade";
    //ATIVIDADE COLUNAS
    public static final String COL_1_ATIVIDADE = "pk_atividade";
    public static final String COL_2_ATIVIDADE = "nome";
    public static final String COL_3_ATIVIDADE = "dataEntrega";
    public static final String COL_4_ATIVIDADE = "nota";
    public static final String COL_5_ATIVIDADE = "fk_disciplina";

    public static String dropTabelaAtividade(){
        return "DROP TABLE "+ ATIVIDADE_TABELA;
    }

    public static String criaTabelaAtividade(){
        String CRIA_ATIVIDADE = "CREATE TABLE " + ATIVIDADE_TABELA
                + "(" + COL_1_ATIVIDADE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2_ATIVIDADE + " TEXT, "
                + COL_3_ATIVIDADE + " TEXT, "
                + COL_4_ATIVIDADE + " REAL, "
                + COL_5_ATIVIDADE + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_5_ATIVIDADE + ") REFERENCES " + DISCIPLINA_TABELA + "(" + COL_1_DISC + "));";
        return CRIA_ATIVIDADE;
    }
}

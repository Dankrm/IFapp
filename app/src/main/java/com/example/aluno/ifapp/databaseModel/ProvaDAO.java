package com.example.aluno.ifapp.databaseModel;

import android.content.Context;

import java.math.MathContext;

import static com.example.aluno.ifapp.databaseModel.DisciplinaDAO.*;

/**
 * Created by dangh on 26/05/2018.
 */

public class ProvaDAO {
    private MainDatabase db;


    public ProvaDAO(Context ctx) {
        db = MainDatabase.getInstance(ctx);
    }

    public static final String PROVA_TABELA = "prova";

    //PROVA COLUNAS
    public static final String COL_1_PROVA = "pk_prova";
    public static final String COL_2_PROVA = "conteudo";
    public static final String COL_3_PROVA = "data";
    public static final String COL_4_PROVA = "nota";
    public static final String COL_5_PROVA = "fk_disciplina";

    public static String dropTabelaProva(){
        return "DROP TABLE "+ PROVA_TABELA;
    }

    public static String CriaTabelaProva(){
        String CRIA_PROVA = "CREATE TABLE " + PROVA_TABELA
                + "(" + COL_1_PROVA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2_PROVA + " TEXT, "
                + COL_3_PROVA + " TEXT, "
                + COL_4_PROVA + " REAL, "
                + COL_5_PROVA + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_5_PROVA + ") REFERENCES " + DISCIPLINA_TABELA + "(" + COL_1_DISC + "));";
        return CRIA_PROVA;
    }

}

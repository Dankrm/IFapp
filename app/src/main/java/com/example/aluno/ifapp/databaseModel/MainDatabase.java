package com.example.aluno.ifapp.databaseModel;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno.ifapp.Disciplina;
import com.example.aluno.ifapp.MainActivity;

import java.io.File;
import java.nio.file.Path;
import java.sql.SQLData;

public class MainDatabase extends SQLiteOpenHelper {
    private AlertDialog alerta;

    //NOME BANCO
    public static final String NOME_BANCO = "ifapp";
    public static final int VERSAO_BANCO = 1;



    private static MainDatabase mainDatabase;
    private SQLiteDatabase db;

    public static synchronized MainDatabase getInstance(Context ctx){
        if(mainDatabase == null) {
            mainDatabase = new MainDatabase(ctx);
        }
            return mainDatabase;

    }
    public SQLiteDatabase getDatabase(){
        return this.db;
    }


    private MainDatabase(Context ctx) {
        super(ctx, NOME_BANCO, null, VERSAO_BANCO);

        String PATH_DB = ctx.getDatabasePath(NOME_BANCO).toString();
        System.out.println(PATH_DB);
        db = getWritableDatabase();
        db.setForeignKeyConstraintsEnabled(true);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CursoDAO.criaTabelaCurso());
        db.execSQL(AlunoDAO.criaTabelaAluno());
        db.execSQL(DisciplinaDAO.criaTabelaDisciplina());
        db.execSQL(ProvaDAO.CriaTabelaProva());
        db.execSQL(AtividadeDAO.criaTabelaAtividade());
        db.execSQL(AnotacaoDAO.criaTabelaAnotacao());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        db.execSQL(CursoDAO.dropTabelaCurso());
        db.execSQL(AlunoDAO.dropTabelaAluno());
        db.execSQL(DisciplinaDAO.dropTabelaDisciplina());
        db.execSQL(ProvaDAO.dropTabelaProva());
        db.execSQL(AtividadeDAO.dropTabelaAtividade());
        db.execSQL(AnotacaoDAO.dropTabelaAnotacao());
        onCreate(db);
    }















}

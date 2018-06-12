package com.example.aluno.ifapp.databaseModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.aluno.ifapp.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dangh on 26/05/2018.
 */

public class CursoDAO{
    MainDatabase mainDb;

    public static final String CURSO_TABELA = "curso";
    //CURSO COLUNAS
    public static final String COL_1_CURSO = "pk_curso";
    public static final String COL_2_CURSO = "nome";
    public static final String COL_3_CURSO = "ano";

    public CursoDAO(Context ctx) {
        mainDb = MainDatabase.getInstance(ctx);
    }

    public static String dropTabelaCurso(){
        return "DROP TABLE IF EXISTS"+ CURSO_TABELA;
    }

    public static String criaTabelaCurso(){
        String CRIA_CURSO = "CREATE TABLE " + CURSO_TABELA
                + "(" + COL_1_CURSO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2_CURSO + " TEXT, "
                + COL_3_CURSO + " INTEGER)";
        return CRIA_CURSO;
    }

    public boolean inserir(Curso curso) {
        ContentValues cv = new ContentValues();
        cv.put(COL_2_CURSO, curso.getNome());
        cv.put(COL_3_CURSO, curso.getAno());
        try{
            mainDb.getWritableDatabase();
            mainDb.getDatabase().beginTransaction();
            mainDb.getDatabase().insert(CURSO_TABELA, null, cv);
            mainDb.getDatabase().setTransactionSuccessful();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            mainDb.getDatabase().endTransaction();
        }
    }


    public Curso selecionaCursoPorId(int pk_curso){
        mainDb.getReadableDatabase();
        mainDb.getDatabase().beginTransaction();
        String SELECIONA_CURSO = "SELECT * FROM "+ CURSO_TABELA +" WHERE "+ COL_1_CURSO +" = "+ pk_curso;

        Cursor c = mainDb.getDatabase().rawQuery(SELECIONA_CURSO, null);

        Curso curso = new Curso();
        if(c.moveToFirst()){
            curso.setPk_curso(c.getInt(0));
            curso.setNome(c.getString(1));
            curso.setAno(c.getInt(2));
        }
        c.close();
        mainDb.getDatabase().setTransactionSuccessful();
        mainDb.getDatabase().endTransaction();
        return curso;

    }

    public List<Curso> getCursos(){
        mainDb.getReadableDatabase();
        mainDb.getDatabase().beginTransaction();
        String LISTA_CURSO = "SELECT * FROM "+ CURSO_TABELA;
        ArrayList<Curso> cursos = new ArrayList<>();
        Cursor c = mainDb.getDatabase().rawQuery(LISTA_CURSO, null);

        if(c.moveToFirst()){
            do{
                Curso curso = new Curso();
                curso.setPk_curso(c.getInt(0));
                curso.setNome(c.getString(1));
                curso.setAno(c.getInt(2));
                cursos.add(curso);
            }while(c.moveToNext());
        }
        c.close();
        mainDb.getDatabase().setTransactionSuccessful();
        mainDb.getDatabase().endTransaction();
        return cursos;
    }

    public boolean atualizar(Curso curso){
        mainDb.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1_CURSO, curso.getPk_curso());
        cv.put(COL_2_CURSO, curso.getNome());
        cv.put(COL_3_CURSO, curso.getAno());
        String where = COL_1_CURSO + " = '"+ curso.getPk_curso()+ "'";
        mainDb.getDatabase().beginTransaction();
        try{
            mainDb.getDatabase().update(CURSO_TABELA, cv, where, null);
            mainDb.getDatabase().setTransactionSuccessful();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            mainDb.getDatabase().endTransaction();
        }
    }

}


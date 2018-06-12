package com.example.aluno.ifapp.databaseModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.aluno.ifapp.Aluno;
import com.example.aluno.ifapp.Curso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.aluno.ifapp.databaseModel.CursoDAO.*;

/**
 * Created by dangh on 26/05/2018.
 */

public class AlunoDAO {
    private MainDatabase mainDb;
    private CursoDAO cursoDAO;


    public static final String ALUNO_TABELA = "aluno";

    //ALUNO COLUNAS
    public static final String COL_1_ALUNO = "pk_aluno";
    public static final String COL_2_ALUNO = "nome";
    public static final String COL_3_ALUNO = "fk_curso";



    public AlunoDAO(Context ctx) {
        mainDb = MainDatabase.getInstance(ctx);
    }

    public static String dropTabelaAluno(){
        return "DROP TABLE IF EXISTS"+ ALUNO_TABELA;
    }

    public static String criaTabelaAluno(){
        String CRIA_ALUNO = "CREATE TABLE " + ALUNO_TABELA
                + "(" + COL_1_ALUNO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2_ALUNO + " TEXT, "
                + COL_3_ALUNO + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_3_ALUNO + ") REFERENCES " + CURSO_TABELA + "(" + COL_1_CURSO + "))";
        return CRIA_ALUNO;
    }

    public boolean inserir(String nome, Curso curso) {
        mainDb.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2_ALUNO, nome);
        cv.put(COL_3_ALUNO, curso.getPk_curso());
        mainDb.getDatabase().beginTransaction();
        try{
            mainDb.getDatabase().insert(ALUNO_TABELA, null, cv);
            mainDb.getDatabase().setTransactionSuccessful();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            mainDb.getDatabase().endTransaction();

        }
    }
    public List<Aluno> getAlunos(){

        mainDb.getReadableDatabase();
        mainDb.getDatabase().beginTransaction();
        String LISTA_ALUNO = "SELECT * FROM "+ ALUNO_TABELA;

        Cursor c = mainDb.getDatabase().rawQuery(LISTA_ALUNO, null);

        ArrayList<Aluno> alunos = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                Aluno aluno = new Aluno();
                aluno.setPk_aluno(c.getInt(c.getColumnIndexOrThrow(COL_1_ALUNO)));
                aluno.setNome(c.getString(c.getColumnIndexOrThrow(COL_2_ALUNO)));


                aluno.setCurso(cursoDAO.selecionaCursoPorId(c.getInt(c.getColumnIndexOrThrow(COL_3_ALUNO))));

                alunos.add(aluno);

            }while(c.moveToNext());
        }
        c.close();
        mainDb.getDatabase().setTransactionSuccessful();
        mainDb.getDatabase().endTransaction();
        return alunos;
    }
}

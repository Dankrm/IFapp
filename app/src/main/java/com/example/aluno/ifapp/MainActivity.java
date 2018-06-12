package com.example.aluno.ifapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aluno.ifapp.databaseModel.AlunoDAO;
import com.example.aluno.ifapp.databaseModel.CursoDAO;
import com.example.aluno.ifapp.databaseModel.MainDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainDatabase db;
    private CursoDAO cursoDAO;
    private AlunoDAO alunoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_anotacoes) {
            startActivity(new Intent(MainActivity.this, TelaAnotacoes.class));
        } else if (id == R.id.nav_avaliacoes) {
            startActivity(new Intent(MainActivity.this, TelaAvaliacoes.class));
        } else if (id == R.id.nav_calculonotas) {
            startActivity(new Intent(MainActivity.this, TelaCalculoNotas.class));
        } else if (id == R.id.nav_horario) {
            startActivity(new Intent(MainActivity.this, TelaHorario.class));
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(MainActivity.this, TelaSobre.class));
        } else if (id == R.id.nav_ementas) {
            startActivity(new Intent(MainActivity.this, TelaEmentas.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void verAlunos(View view){

        alunoDAO = new AlunoDAO(getApplicationContext());
        List<Aluno> alunos = alunoDAO.getAlunos();

        for(int i = 0; i<alunos.size(); i++){
            Aluno aluno = alunos.get(i);
            System.out.println(aluno.toString());
        }

    }
    public void verCursos(View view){

        cursoDAO = new CursoDAO(getApplicationContext());
        ArrayList<Curso> cursos = cursoDAO.getCursos();

        for(int i = 0; i<cursos.size(); i++){
            Curso curso = cursos.get(i);
            System.out.println(curso.toString());
        }

    }

}

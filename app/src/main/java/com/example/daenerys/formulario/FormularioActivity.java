package com.example.daenerys.formulario;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ArrayList<String> listaEstado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner2);


        listaEstado.add("Rio de Janeiro");
        listaEstado.add("Minas Gerais");
        listaEstado.add("São Paulo");
        listaEstado.add("Rio Grande do Sul");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaEstado);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin1.setAdapter(spinnerArrayAdapter);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//adcionar figura ao drawable
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                Toast.makeText(FormularioActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();

                //um teste
                switch (menuItem.getItemId()){
                    case R.id.navigation_item_Pessoais:
                        Intent a = new Intent(FormularioActivity.this, InfoPessoais.class);
                        startActivity(a);
                    break;
                    case R.id.navigation_item_formacao:
                        Intent b = new Intent(FormularioActivity.this, Formacao.class);
                        startActivity(b);
                        break;
                    case R.id.navigation_item_experiencia:
                        Intent c = new Intent(FormularioActivity.this, Experiencia.class);
                        startActivity(c);
                        break;
                    case R.id.navigation_item_curso:
                        Intent d = new Intent(FormularioActivity.this, Cursos.class);
                        startActivity(d);
                        break;
                    case R.id.navigation_item_pub:
                        Intent e = new Intent(FormularioActivity.this, Publicacao.class);
                        startActivity(e);
                        break;
                }//case
                //fim fo trcho
                return true;
            }
        });
    }//onCreate

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }//onOptionItemSelected
}//class

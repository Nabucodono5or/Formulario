package com.example.daenerys.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Formacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formacao);
    }//onCreate

    public void voltar(View v){
        Intent e = new Intent(Formacao.this, FormularioActivity.class);
        startActivity(e);
    }//voltar
}//class

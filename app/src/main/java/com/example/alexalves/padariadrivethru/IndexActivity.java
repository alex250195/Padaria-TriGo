package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity {
    private Button btnAcesso;
    private Button btnCadastro;
    private Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        btnAcesso = (Button) findViewById(R.id.btnAcessar);
        btnCadastro = (Button) findViewById(R.id.btnCadastrar);
        btnSobre = (Button) findViewById(R.id.btnSobre);

        btnAcesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Acesso();
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cadastro();
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sobre();
            }
        });
    }

    public void Acesso(){
        Intent acesso = new Intent(this, LoginActivity.class);
        startActivity(acesso);
    }

    public void Cadastro(){
        Intent acesso = new Intent(this, CadastrarActivity.class);
        startActivity(acesso);
    }

    public void Sobre(){
        Intent acesso = new Intent(this, SobreActivity.class);
        startActivity(acesso);
    }

    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onDestroy()
    {
        finish();
        super.onDestroy();
    }
}

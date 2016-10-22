package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button acessar;

    private EditText login;
    private EditText senha;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.txtLogin);
        senha = (EditText) findViewById(R.id.txtSenha);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setText("");
            }
        });

        senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senha.setText("");
            }
        });

        acessar = (Button) findViewById(R.id.btnAcessar);

        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Acesso();
            }
        });
    }

    public void Acesso(){
        Intent acesso = new Intent(this, ComprasActivity.class);
        startActivity(acesso);
    }
}
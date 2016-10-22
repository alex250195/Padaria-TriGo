package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Button acessa = (Button) findViewById(R.id.btnAcessar);

        acessa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Acesso();
            }
        });
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

    public void Acesso(){
        Toast toast = Toast.makeText(getBaseContext(), "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT);
        toast.show();

        Intent produto = new Intent(this, ComprasActivity.class);
        startActivity(produto);
    }
}

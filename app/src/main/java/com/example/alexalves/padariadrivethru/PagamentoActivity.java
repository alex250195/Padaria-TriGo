package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PagamentoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        /*Button pagamento = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[2];
        departamento[0] = "Cartão de Crédito";
        departamento[1] = "Dinheiro";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departamento);
        final ListView listView = (ListView) findViewById(R.id.lvProduto);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pagamento();
            }
        });*/
    }

    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Cartão de Crédito", R.drawable.card);
        ItemListView item2 = new ItemListView("Dinheiro", R.drawable.money);

        itens.add(item1);
        itens.add(item2);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);

        //Cor quando a lista é selecionada para ralagem.
        //listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //Pega o item que foi selecionado.
        //ItemListView item = adapterListView.getItem(position);
        //Demostração

        Pagamento();
    }

    public void Pagamento(){
        Toast toast = Toast.makeText(getBaseContext(), "Compra efetuada com sucesso!", Toast.LENGTH_SHORT);
        toast.show();

        Intent produto = new Intent(this, ComprasActivity.class);
        startActivity(produto);
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

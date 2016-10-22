package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PanificadoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panificado);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carrinho();
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

    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView1>();
        ItemListView1 item1 = new ItemListView1("Pão francês", "R$ 15.49", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Pão de queijo", "R$ 19.00",  R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Pão integral", "R$ 8.59", R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Pão de doce", "R$ 12.49", R.drawable.carrinho2);
        ItemListView1 item5 = new ItemListView1("Pão de forma", "R$ 8.59", R.drawable.carrinho2);
        ItemListView1 item6 = new ItemListView1("Biscoito", "R$ 1.89", R.drawable.carrinho2);
        ItemListView1 item7 = new ItemListView1("Bolacha", "R$ 17.99", R.drawable.carrinho2);
        ItemListView1 item8 = new ItemListView1("Torta", "R$ 82.00", R.drawable.carrinho2);
        ItemListView1 item9 = new ItemListView1("Rocambole", "R$ 39.90", R.drawable.carrinho2);
        ItemListView1 item10 = new ItemListView1("Bolo", "R$ 22.00", R.drawable.carrinho2);
        ItemListView1 item11 = new ItemListView1("Broa", "R$ 5.00", R.drawable.carrinho2);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);
        itens.add(item10);
        itens.add(item11);

        //Cria o adapter
        adapterListView = new AdapterListView1(this, itens);

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

        Produto();
    }

    public void Carrinho(){
        Intent produto = new Intent(this, CarrinhoActivity.class);
        startActivity(produto);
    }

    public void Produto(){
        Toast toast = Toast.makeText(getBaseContext(), "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

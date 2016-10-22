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

public class FriosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frios);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*Button carrinho = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[8];
        departamento[0] = "Mussarela";
        departamento[1] = "Apresuntado";
        departamento[2] = "Bacon";
        departamento[3] = "Blanquet";
        departamento[4] = "Mortadela";
        departamento[5] = "Presunto";
        departamento[6] = "Salame";
        departamento[7] = "Salame italiano";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departamento);
        final ListView listView = (ListView) findViewById(R.id.lvProduto);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto();
            }
        });*/

        carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carrinho();
            }
        });
    }

    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView1>();
        ItemListView1 item1 = new ItemListView1("Mussarela", "R$ 17.10", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Apresuntado", "R$ 11.99", R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Bacon", "R$ 26.90", R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Blanquet", "R$ 29.99", R.drawable.carrinho2);
        ItemListView1 item5 = new ItemListView1("Mortadela", "R$ 24.09", R.drawable.carrinho2);
        ItemListView1 item6 = new ItemListView1("Presunto", "R$ 8.59", R.drawable.carrinho2);
        ItemListView1 item7 = new ItemListView1("Salame", "R$ 21.50", R.drawable.carrinho2);
        ItemListView1 item8 = new ItemListView1("Salame italiano", "R$ 24.09", R.drawable.carrinho2);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);

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

    public void Produto(){
        Toast toast = Toast.makeText(getBaseContext(), "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

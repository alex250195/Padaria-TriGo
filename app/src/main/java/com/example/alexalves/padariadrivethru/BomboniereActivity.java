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

public class BomboniereActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomboniere);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*Button carrinho = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[4];
        departamento[0] = "Balas";
        departamento[1] = "Barras de cereais";
        departamento[2] = "Bombos";
        departamento[3] = "Chicletes";
        departamento[3] = "Drops ou pastilhas";
        departamento[3] = "Pirulitos";
        departamento[3] = "Chocolate";
        departamento[3] = "Doces";

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
        ItemListView1 item1 = new ItemListView1("Bala", "R$ 0.50", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Barra de cereal","R$ 1.50", R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Bombom", "R$ 2.00", R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Doce", "R$ 2.50", R.drawable.carrinho2);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

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

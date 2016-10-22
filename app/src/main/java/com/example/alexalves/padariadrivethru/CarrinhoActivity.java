package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CarrinhoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Button compra = (Button) findViewById(R.id.btnCarrinho);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        /*String[] departamento = new String[5];
        departamento[0] = "Panificados - Pão francês - R$ 2,50";
        departamento[1] = "Panificados - Biscoito - R$ 4,00";
        departamento[2] = "Bomboniére - Bala - R$ 0,50";
        departamento[3] = "Bebidas - Café - R$ 5,50";
        departamento[4] = "Bebidas - Citrus - R$ 10,20";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departamento);
        final ListView listView = (ListView) findViewById(R.id.lvProduto);
        listView.setAdapter(adapter);*/

        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compra();
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
        ItemListView1 item1 = new ItemListView1("Pão Francês", "R$ 3.00", R.drawable.panificadora);
        ItemListView1 item2 = new ItemListView1("Biscoito","R$ 9.45", R.drawable.panificadora);
        ItemListView1 item3 = new ItemListView1("Bala", "R$ 2.00", R.drawable.bomboniere);
        ItemListView1 item4 = new ItemListView1("Café", "R$ 2.00", R.drawable.bebidas);
        ItemListView1 item5 = new ItemListView1("Citrus", "R$ 5.69", R.drawable.bebidas);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);

        //Cria o adapter
        adapterListView = new AdapterListView1(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);

        //Cor quando a lista é selecionada para ralagem.
        //listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }

    public void Compra(){
        Intent produto = new Intent(this, PagamentoActivity.class);
        startActivity(produto);
    }
}

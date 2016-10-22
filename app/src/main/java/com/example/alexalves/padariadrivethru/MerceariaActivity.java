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

public class MerceariaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercearia);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*Button carrinho = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[9];
        departamento[0] = "Achocolatados em pó";
        departamento[1] = "Azeite";
        departamento[2] = "Batata palha";
        departamento[3] = "Biscoitos";
        departamento[4] = "Doces em calda";
        departamento[5] = "Catchup";
        departamento[6] = "Maionese";
        departamento[7] = "Refresco em pó";
        departamento[8] = "Enlatados";

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
        ItemListView1 item1 = new ItemListView1("Achocolatado em pó", "R$ 35.10", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Azeite", "R$ 5.05", R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Batata palha", "R$ 17.90",  R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Biscoito", "R$ 23.90", R.drawable.carrinho2);
        ItemListView1 item5 = new ItemListView1("Doce em calda", "R$ 9.80", R.drawable.carrinho2);
        ItemListView1 item6 = new ItemListView1("Catchup", "R$ 12.26", R.drawable.carrinho2);
        ItemListView1 item7 = new ItemListView1("Maionese", "R$ 3.58", R.drawable.carrinho2);
        ItemListView1 item8 = new ItemListView1("Refresco em pó", "R$ 1.00",  R.drawable.carrinho2);
        ItemListView1 item9 = new ItemListView1("Enlatado", "R$ 3.34", R.drawable.carrinho2);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);

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
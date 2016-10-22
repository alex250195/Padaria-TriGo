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

public class LaticiniosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

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
        setContentView(R.layout.activity_laticinios);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*Button carrinho = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[9];
        departamento[0] = "Leite";
        departamento[1] = "Iorgutes";
        departamento[2] = "Achocolatados líquidos";
        departamento[3] = "Manteiga";
        departamento[4] = "Margarina";
        departamento[5] = "Queijos";
        departamento[6] = "Requeijão";
        departamento[7] = "Ricota";
        departamento[8] = "Coalhada";

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
        ItemListView1 item1 = new ItemListView1("Leite", "R$ 2.38", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Iorgute", "R$ 3.89", R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Achocolatado líquido", "R$ 18.54", R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Manteiga", "R$ 11.98", R.drawable.carrinho2);
        ItemListView1 item5 = new ItemListView1("Queijo", "R$ 14.00", R.drawable.carrinho2);
        ItemListView1 item6 = new ItemListView1("Requeijão", "R$ 5.65", R.drawable.carrinho2);
        ItemListView1 item7 = new ItemListView1("Ricota", "R$ 9.90", R.drawable.carrinho2);
        ItemListView1 item8 = new ItemListView1("Coalha", "R$ 2.09", R.drawable.carrinho2);

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

    public void Produto(){
        Toast toast = Toast.makeText(getBaseContext(), "Produto Inserido!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

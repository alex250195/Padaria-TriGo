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

public class BebidasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private AdapterListView1 adapterListView;
    private ArrayList<ItemListView1> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvProduto);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*Button carrinho = (Button) findViewById(R.id.btnCarrinho);

        String[] departamento = new String[11];
        departamento[0] = "Café";
        departamento[1] = "Água de coco";
        departamento[2] = "Água mineral";
        departamento[3] = "Água tônica";
        departamento[4] = "Isôtonicos";
        departamento[5] = "Energéticos";
        departamento[6] = "Refrigerantes";
        departamento[7] = "Citrus";
        departamento[8] = "Cerveja";
        departamento[9] = "Sucos prontos para beber";
        departamento[10] = "Sucos naturais";

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
        ItemListView1 item1 = new ItemListView1("Café", "R$ 2.00", R.drawable.carrinho2);
        ItemListView1 item2 = new ItemListView1("Água de coco", "R$ 1.85", R.drawable.carrinho2);
        ItemListView1 item3 = new ItemListView1("Água mineral", "R$ 2.00", R.drawable.carrinho2);
        ItemListView1 item4 = new ItemListView1("Água tônica", "R$ 2.65", R.drawable.carrinho2);
        ItemListView1 item5 = new ItemListView1("Isotônico", "R$ 3.50", R.drawable.carrinho2);
        ItemListView1 item6 = new ItemListView1("Energético", "R$ 2.40", R.drawable.carrinho2);
        ItemListView1 item7 = new ItemListView1("Refrigerante", "R$ 1.75", R.drawable.carrinho2);
        ItemListView1 item8 = new ItemListView1("Citrus", "R$ 5.69", R.drawable.carrinho2);
        ItemListView1 item9 = new ItemListView1("Cerveja", "R$ 2.48", R.drawable.carrinho2);
        ItemListView1 item10 = new ItemListView1("Suco pronto para beber", "R$ 1.90", R.drawable.carrinho2);
        ItemListView1 item11 = new ItemListView1("Suco natural", "R$ 4.90", R.drawable.carrinho2);


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

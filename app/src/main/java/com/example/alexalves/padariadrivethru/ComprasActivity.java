package com.example.alexalves.padariadrivethru;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ComprasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.lvDepartamento);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();

        ImageButton carrinho = (ImageButton) findViewById(R.id.btnCarrinho);

        /*String[] departamento = new String[9];
        departamento[0] = "Produtos Panificados";
        departamento[1] = "Salgados";
        departamento[2] = "Mercearia";
        departamento[3] = "Bomboniére";
        departamento[4] = "Bebidas";
        departamento[5] = "Frios";
        departamento[6] = "Congelados";
        departamento[7] = "Laticínios";
        departamento[8] = "Sorvetes";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departamento);
        final ListView listView = (ListView) findViewById(R.id.lvDepartamento);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto(position);
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
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Produtos Panificados", R.drawable.panificadora);
        ItemListView item2 = new ItemListView("Salgados", R.drawable.salgados);
        ItemListView item3 = new ItemListView("Mercearia", R.drawable.mercearia);
        ItemListView item4 = new ItemListView("Bomboniére", R.drawable.bomboniere);
        ItemListView item5 = new ItemListView("Bebidas", R.drawable.bebidas);
        ItemListView item6 = new ItemListView("Frios", R.drawable.frios);
        ItemListView item7 = new ItemListView("Congelados", R.drawable.congelados);
        ItemListView item8 = new ItemListView("Laticínios", R.drawable.laticinio);
        ItemListView item9 = new ItemListView("Sorvetes", R.drawable.sorvete);


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

        Produto(position);
    }

    public void Produto(int id){
        if(id == 0){
            Intent produto = new Intent(this, PanificadoActivity.class);
            startActivity(produto);
        }
        else if(id == 1){
            Intent produto = new Intent(this, SalgadosActivity.class);
            startActivity(produto);
        }
        else if(id == 2){
            Intent produto = new Intent(this, MerceariaActivity.class);
            startActivity(produto);
        }
        else if(id == 3){
            Intent produto = new Intent(this, BomboniereActivity.class);
            startActivity(produto);
        }
        else if(id == 4){
            Intent produto = new Intent(this, BebidasActivity.class);
            startActivity(produto);
        }
        else if(id == 5){
            Intent produto = new Intent(this, FriosActivity.class);
            startActivity(produto);
        }
        else if(id == 6){
            Intent produto = new Intent(this, CongeladosActivity.class);
            startActivity(produto);
        }
        else if(id == 7){
            Intent produto = new Intent(this, LaticiniosActivity.class);
            startActivity(produto);
        }
        else if(id == 8){
            Intent produto = new Intent(this, SorveteActivity.class);
            startActivity(produto);
        }
    }

    public void Carrinho(){
        Intent produto = new Intent(this, CarrinhoActivity.class);
        startActivity(produto);
    }
}

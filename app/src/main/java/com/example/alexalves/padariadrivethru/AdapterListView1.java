package com.example.alexalves.padariadrivethru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alex Alves on 22/10/2016.
 */
public class AdapterListView1 extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<ItemListView1> itens;

    public AdapterListView1(Context context, ArrayList<ItemListView1> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return itens.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public ItemListView1 getItem(int position)
    {
        return itens.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posção.
        ItemListView1 item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_list_view1, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.textPreco)).setText(item.getTextoPreco());
        ((TextView) view.findViewById(R.id.textDesc)).setText(item.getTextoDesc());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(item.getIconeRid());

        return view;
    }
}

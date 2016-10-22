package com.example.alexalves.padariadrivethru;

/**
 * Created by Alex Alves on 22/10/2016.
 */
public class ItemListView1 {
    private String textoDesc;
    private String textoPreco;
    private int iconeRid;

    public ItemListView1()
    {
    }

    public ItemListView1(String desc, String preco, int iconeRid)
    {
        this.textoDesc = desc;
        this.textoPreco = preco;
        this.iconeRid = iconeRid;
    }

    public int getIconeRid()
    {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid)
    {
        this.iconeRid = iconeRid;
    }

    public String getTextoDesc()
    {
        return textoDesc;
    }

    public void setTextoDesc(String texto)
    {
        this.textoDesc = texto;
    }

    public String getTextoPreco()
    {
        return textoPreco;
    }

    public void setTextoPreco(String texto)
    {
        this.textoPreco = texto;
    }
}

package com.example.appamd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MedicosAdapter extends BaseAdapter {

    private Context ctx;
    private List<Medico> lista;

    public MedicosAdapter(Context ctx2, List<Medico>lista2){
        ctx = ctx2;
        lista = lista2;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Medico getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;

        if (convertView == null){
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
            v = inflater.inflate(R.layout.item_lista, null);
        }else{
            v = convertView;
        }

        Medico m = getItem(position);

        TextView itemNome = (TextView) v.findViewById(R.id.itemNome);
        TextView itemEspecialidade = (TextView) v.findViewById(R.id.itemEspecialidade);

        itemNome.setText(m.getNome());
        itemEspecialidade.setText(m.getEspecialidade());




        return v;
    }
}

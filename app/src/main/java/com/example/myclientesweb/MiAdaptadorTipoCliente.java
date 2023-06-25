package com.example.myclientesweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

public class MiAdaptadorTipoCliente extends BaseAdapter{
    Context context;
    List<TipoCliente> tipoClientes;

    public MiAdaptadorTipoCliente(Context context, List<TipoCliente> tipoClientes) {
        this.context = context;
        this.tipoClientes = tipoClientes;
    }

    @Override
    public int getCount() {
        return tipoClientes.size();
    }

    @Override
    public Object getItem(int position) {
        return tipoClientes.get(position);
    }

    @Override

    public long getItemId(int position) {
        return tipoClientes.get(position).getIdTipoCliente();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fila  = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            fila = inflater.inflate(R.layout.misfilastipoclientes, null);
        }else{
            fila = (View) convertView;
        }
        TextView txtNombre = fila.findViewById(R.id.txtNombreTipoCliente);
        TextView txtDetalle = fila.findViewById(R.id.txtDetalleTipoCliente);
        TextView txtIdTipoCliente = fila.findViewById(R.id.txtIdTipoCliente);
        
        txtNombre.setText(tipoClientes.get(position).getNombre());
        txtDetalle.setText(tipoClientes.get(position).getDetalle());
        txtIdTipoCliente.setText(String.valueOf(tipoClientes.get(position).getIdTipoCliente()));

        return fila;

    }



}

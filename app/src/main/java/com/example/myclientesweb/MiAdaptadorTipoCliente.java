package com.example.myclientesweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myclientesweb.API.ClienteAPI;
import com.example.myclientesweb.API.RetrofitCliente;
import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Button btnEditarTipoCliente = fila.findViewById(R.id.btnEditarTipoCliente);
        Button btnEliminarTipoCliente = fila.findViewById(R.id.btnEliminarTipoCliente);
        
        txtNombre.setText(tipoClientes.get(position).getNombre());
        txtDetalle.setText(tipoClientes.get(position).getDetalle());
        txtIdTipoCliente.setText(String.valueOf(tipoClientes.get(position).getIdTipoCliente()));

        btnEditarTipoCliente.setOnClickListener(new View.OnClickListener() {
            ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String detalle = txtDetalle.getText().toString();
                int idTipoCliente = Integer.parseInt(txtIdTipoCliente.getText().toString());
                TipoCliente tipoCliente = new TipoCliente(nombre, detalle, idTipoCliente);
                Call<Void> call = clienteAPI.updateTipoCliente(tipoCliente);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast toast = Toast.makeText(context, "Tipo de Cliente Actualizado", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast toast = Toast.makeText(context, "Error al Actualizar Tipo de Cliente", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });

        btnEliminarTipoCliente.setOnClickListener(new View.OnClickListener() {
            ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String detalle = txtDetalle.getText().toString();
                int idTipoCliente = Integer.parseInt(txtIdTipoCliente.getText().toString());
                TipoCliente tipoCliente = new TipoCliente(nombre, detalle, idTipoCliente);
                Call<Void> call = clienteAPI.deleteTipoCliente(tipoCliente);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast toast = Toast.makeText(context, "Tipo de Cliente Eliminado", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast toast = Toast.makeText(context, "Error al Eliminar Tipo de Cliente", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });

        return fila;

    }



}

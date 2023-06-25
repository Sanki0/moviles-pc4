package com.example.myclientesweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myclientesweb.API.ClienteAPI;
import com.example.myclientesweb.API.RetrofitCliente;
import com.example.myclientesweb.MODELO.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MiAdaptadorCliente extends BaseAdapter {
    Context context;
    List<Cliente> clientes;
    MiAdaptadorCliente(Context c, List<Cliente> cs){
        this.context = c;
        this.clientes = cs;
    }
    @Override
    public int getCount(){
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getIdcliente();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fila = null;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            fila = inflater.inflate(R.layout.misfilasclientes,null);
        }else{
            fila = convertView;
        }
        TextView txtminombreweb = fila.findViewById(R.id.txtminombreweb);
        TextView txtmidniweb = fila.findViewById(R.id.txtmidniweb);
        TextView txtmitelefonoweb = fila.findViewById(R.id.txtmitelefonoweb);
        TextView txtmicorreoweb = fila.findViewById(R.id.txtmicorreoweb);
        TextView txtmiestadoweb = fila.findViewById(R.id.txtmiestadoweb);
        TextView txtmiidtipoclienteweb = fila.findViewById(R.id.txtmiidtipoclienteweb);
        TextView txtmiidclienteweb = fila.findViewById(R.id.txtmiidclienteweb);


        Button btnEditarCliente = fila.findViewById(R.id.btnEditarCliente);
        Button btnEliminarCliente = fila.findViewById(R.id.btnEliminarCliente);

        txtminombreweb.setText(clientes.get(position).getNombre());
        txtmidniweb.setText(clientes.get(position).getDni());
        txtmitelefonoweb.setText(clientes.get(position).getTelefono());
        txtmicorreoweb.setText(clientes.get(position).getCorreo());
        txtmiestadoweb.setText(clientes.get(position).getEstado());
        txtmiidtipoclienteweb.setText(String.valueOf(clientes.get(position).getIdTipoCliente()));
        txtmiidclienteweb.setText(String.valueOf(clientes.get(position).getIdcliente()));

        btnEditarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Editar",Toast.LENGTH_LONG).show();
            }
        });

        btnEliminarCliente.setOnClickListener(new View.OnClickListener() {
            ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
            @Override
            public void onClick(View v) {
                String nombre = txtminombreweb.getText().toString();
                String dni = txtmidniweb.getText().toString();
                String telefono = txtmitelefonoweb.getText().toString();
                String correo = txtmicorreoweb.getText().toString();
                String estado = txtmiestadoweb.getText().toString();
                int idTipoCliente = Integer.parseInt(txtmiidtipoclienteweb.getText().toString());
                int idcliente = Integer.parseInt(txtmiidclienteweb.getText().toString());

                Cliente cliente = new Cliente(nombre,dni,telefono,correo,estado,idTipoCliente,idcliente);
                Call<Void> call = clienteAPI.deleteCliente(cliente);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(context,"Eliminado",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        
        return fila;
    }

}


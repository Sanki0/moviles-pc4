package com.example.myclientesweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myclientesweb.API.ClienteAPI;
import com.example.myclientesweb.API.RetrofitCliente;
import com.example.myclientesweb.MODELO.Cliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityTipoCliente extends AppCompatActivity {

    Button btnAgregar, btnModificar, btnEliminar, btnListar;
    TextView txtNombre, txtDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_cliente);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnListar = findViewById(R.id.btnListar);

        txtNombre = findViewById(R.id.txtNombre);
        txtDetalle = findViewById(R.id.txtDetalle);

        btnListar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTipoCliente.this, ListarTipoCliente.class);
                startActivity(intent);
            }
        });

        btnAgregar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String detalle = txtDetalle.getText().toString();

                ClienteAPI clienteApi = RetrofitCliente.getInstance().create(ClienteAPI.class);
                final Cliente cliente = new Cliente(nombre, detalle, "dsad", "sads", "dsa", 0);
                Call<Cliente> call = clienteApi.setCliente(cliente);
                call.enqueue(new Callback<Cliente>() {
                    @Override
                    public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(ActivityTipoCliente.this, "Se ha registrado correctamente", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ActivityTipoCliente.this, "No se ha registrado correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Cliente> call, Throwable t) {
                        Toast.makeText(ActivityTipoCliente.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
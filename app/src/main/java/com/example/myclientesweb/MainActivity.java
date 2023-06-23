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

public class MainActivity extends AppCompatActivity {
    Button btnlistarweb,btnagregarweb;
    TextView txtnombre,txtdni,txttelefono,txtcorreo;

    Button btnTipoCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtdni = (TextView) findViewById(R.id.txtdni);
        txttelefono = (TextView) findViewById(R.id.txttelefono);
        txtcorreo = (TextView) findViewById(R.id.txtcorreo);

        btnlistarweb = (Button) findViewById(R.id.btnlistarweb);
        btnlistarweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainListarclienteweb.class);
                startActivity(intent);
            }
        });

        btnTipoCliente = findViewById(R.id.btnTipoCliente);
        btnTipoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTipoCliente.class);
                startActivity(intent);
            }
        });

        btnagregarweb = (Button) findViewById(R.id.btnagregarweb);
        btnagregarweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtnombre.getText().toString();
                String dni = txtdni.getText().toString();
                String telefono = txttelefono.getText().toString();
                String correo = txtcorreo.getText().toString();

                ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
                final Cliente cliente = new Cliente(nombre,dni,telefono,correo,"A",0);
                Call<Cliente> call = clienteAPI.setCliente(cliente);
                call.enqueue(new Callback<Cliente>() {
                    @Override
                    public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"OK2",Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Cliente> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                txtnombre.setText("");
                txtdni.setText("");
                txttelefono.setText("");
                txtcorreo.setText("");
            }
        });
    }
}
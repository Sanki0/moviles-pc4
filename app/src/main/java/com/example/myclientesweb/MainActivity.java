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
import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnAgregarCliente, btnListarCliente, btnTipoCliente;
    TextView txtnombre,txtdni,txttelefono,txtcorreo, txtestado, txtIdTipoCliente;

    TextView lblInfoIdTipoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtdni = (TextView) findViewById(R.id.txtdni);
        txttelefono = (TextView) findViewById(R.id.txttelefono);
        txtcorreo = (TextView) findViewById(R.id.txtcorreo);
        txtestado = (TextView) findViewById(R.id.txtestado);
        txtIdTipoCliente = (TextView) findViewById(R.id.txtIdTipoCliente);

        lblInfoIdTipoCliente = (TextView) findViewById(R.id.lblInfoIdTipoCliente);

        // lblInfoIdTipoCliente will change its content with a message that we will receive from an api call
        ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
        Call<List<TipoCliente>> call = clienteAPI.getTipoClientes2();

        call.enqueue(new Callback<List<TipoCliente>>() {
            @Override
            public void onResponse(Call<List<TipoCliente>> call, Response<List<TipoCliente>> response) {
                if(response.isSuccessful()){
                    List<TipoCliente> tipoClientes = response.body();
                    String message = "";
                    for(TipoCliente tipoCliente : tipoClientes){
                        message += tipoCliente.getIdTipoCliente() + " " + tipoCliente.getNombre() + "\t\t\t";
                    }
                    lblInfoIdTipoCliente.setText(message);
                }else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<TipoCliente>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        btnListarCliente = (Button) findViewById(R.id.btnlistarweb);
        btnListarCliente.setOnClickListener(new View.OnClickListener() {
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

        btnAgregarCliente = (Button) findViewById(R.id.btnagregarweb);
        btnAgregarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtnombre.getText().toString();
                String dni = txtdni.getText().toString();
                String telefono = txttelefono.getText().toString();
                String correo = txtcorreo.getText().toString();
                String estado = txtestado.getText().toString();
                int idTipoCliente = Integer.parseInt(txtIdTipoCliente.getText().toString());

                ClienteAPI clienteAPI = RetrofitCliente.getInstance().create(ClienteAPI.class);
                final Cliente cliente = new Cliente(nombre,dni,telefono,correo,estado,idTipoCliente);
                Call<Void> call = clienteAPI.setCliente(cliente);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"OK2",Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

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
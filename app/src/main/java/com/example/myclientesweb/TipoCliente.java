package com.example.myclientesweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TipoCliente extends AppCompatActivity {

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
                Intent intent = new Intent(TipoCliente.this, ListarTipoCliente.class);
                startActivity(intent);
            }
        });

    }
}
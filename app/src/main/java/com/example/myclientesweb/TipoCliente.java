package com.example.myclientesweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TipoCliente extends AppCompatActivity {

    Button btnAgregar, btnModificar, btnEliminar, btnListar;
    TextView txtNombre, txtDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_cliente);


    }
}
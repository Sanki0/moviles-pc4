package com.example.myclientesweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myclientesweb.API.ClienteAPI;
import com.example.myclientesweb.API.RetrofitCliente;
import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ListarTipoCliente extends AppCompatActivity {

    ClienteAPI clienteAPI;

    ListView lvTipoCliente;

    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_tipo_cliente);

        lvTipoCliente = findViewById(R.id.lvTipoCliente);

        Retrofit retrofit = RetrofitCliente.getInstance();

        clienteAPI = retrofit.create(ClienteAPI.class);

        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(clienteAPI.getTipoClientes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<TipoCliente>>() {
                    @Override
                    public void accept(List<TipoCliente> tipoClientes) throws Exception {
                        displayData(tipoClientes);
                    }
                }));
    }

    private void displayData(List<TipoCliente> tipoClientes) {
        MiAdaptadorTipoCliente adapter = new MiAdaptadorTipoCliente(this, tipoClientes);
        lvTipoCliente.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    
}
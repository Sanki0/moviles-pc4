package com.example.myclientesweb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import com.example.myclientesweb.API.ClienteAPI;
import com.example.myclientesweb.API.RetrofitCliente;
import com.example.myclientesweb.MODELO.Cliente;

public class MainListarclienteweb extends AppCompatActivity {
    ClienteAPI clienteAPI;
    ListView lvcontactoweb;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listarclienteweb);
        lvcontactoweb = (ListView) findViewById(R.id.lvcontactoweb);
        /*Conexion*/
        Retrofit retrofit = RetrofitCliente.getInstance();
        clienteAPI = retrofit.create(ClienteAPI.class);
        /*Cargar los datos del API*/
        cargardatos();
    }
    private void cargardatos(){
        compositeDisposable.add(clienteAPI.getClientes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Cliente>>() {
            @Override
            public void accept(List<Cliente> clientes) throws Exception {
                mostrardatos(clientes);
            }
        }));
    }
    private void mostrardatos(List<Cliente> clientes){
        MiAdaptadorCliente miAdaptadorCliente = new MiAdaptadorCliente(this,clientes);
        lvcontactoweb.setAdapter(miAdaptadorCliente);
    }
    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }
}
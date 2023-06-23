package com.example.myclientesweb.API;

import io.reactivex.Observable;
import com.example.myclientesweb.MODELO.Cliente;
import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;

public interface ClienteAPI {
    @GET("listarclientes")
    Observable<List<Cliente>> getClientes();

    @POST("guardarcliente")
    Call<Cliente> setCliente(@Body Cliente cliente);
}

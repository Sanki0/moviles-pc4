package com.example.myclientesweb.API;

import io.reactivex.Observable;
import com.example.myclientesweb.MODELO.Cliente;
import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.PUT;

public interface ClienteAPI {
    @GET("clientes")
    Observable<List<Cliente>> getClientes();

    @POST("cliente")
    Call<Void> setCliente(@Body Cliente cliente);

    @PUT("cliente")
    Call<Void> updateCliente(@Body Cliente cliente);

    @HTTP(method = "DELETE", path = "cliente", hasBody = true)
    Call<Void> deleteCliente(@Body Cliente cliente);

    @GET("tipoClientes")
    Observable<List<TipoCliente>> getTipoClientes();

    @GET("tipoClientes")
    Call<List<TipoCliente>> getTipoClientes2();

    @POST("tipoCliente")
    Call<Void> setTipoCliente(@Body TipoCliente tipoCliente);

    @PUT("tipoCliente")
    Call<Void> updateTipoCliente(@Body TipoCliente tipoCliente);

    @HTTP(method = "DELETE", path = "tipoCliente", hasBody = true)
    Call<Void> deleteTipoCliente(@Body TipoCliente tipoCliente);

}

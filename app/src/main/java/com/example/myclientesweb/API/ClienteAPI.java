package com.example.myclientesweb.API;

import io.reactivex.Observable;
import com.example.myclientesweb.MODELO.Cliente;
import com.example.myclientesweb.MODELO.TipoCliente;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.PUT;

public interface ClienteAPI {
    @GET("clientes")
    Observable<List<Cliente>> getClientes();

    @POST("cliente")
    Call<Cliente> setCliente(@Body Cliente cliente);

    @PUT("cliente")
    Call<Cliente> updateCliente(@Body Cliente cliente);
    
    @DELETE("cliente")
    Call<Cliente> deleteCliente(@Body Cliente cliente);

    @GET("tipoClientes")
    Observable<List<TipoCliente>> getTipoClientes();

    @POST("tipoCliente")
    Call<Void> setTipoCliente(@Body TipoCliente tipoCliente);

    @PUT("tipoCliente")
    void updateTipoCliente(@Body TipoCliente tipoCliente);

    @DELETE("tipoCliente")
    void deleteTipoCliente(@Body TipoCliente tipoCliente);

}

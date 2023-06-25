package com.example.myclientesweb.MODELO;

public class TipoCliente {

    private String nombre = "";
    private String detalle = "";
    private int idTipoCliente = 0;

    public TipoCliente() {
    }

    public TipoCliente(String nombre, String detalle, int idTipoCliente) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.idTipoCliente = idTipoCliente;
    }

    public TipoCliente(String nombre, String detalle) {
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    @Override
    public String toString() {
        return "TipoCliente{" +
                "nombre='" + nombre + '\'' +
                ", detalle='" + detalle + '\'' +
                ", idTipoCliente=" + idTipoCliente +
                '}';
    }

    public String toJsonUpdate() {
        return "{" +
                "\"nombre\":\"" + nombre + '\"' +
                ", \"detalle\":\"" + detalle + '\"' +
                ", \"idTipoCliente\":" + idTipoCliente +
                '}';
    }

    public String toJsonCreate() {
        return "{" +
                "\"nombre\":\"" + nombre + '\"' +
                ", \"detalle\":\"" + detalle + '\"' +
                '}';
    }
}

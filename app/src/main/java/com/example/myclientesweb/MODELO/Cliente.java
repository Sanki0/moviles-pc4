package com.example.myclientesweb.MODELO;

public class Cliente {
    private String nombre = "";
    private String dni = "";
    private String telefono = "";
    private String correo = "";
    private String estado="";//A I
    private int idTipoCliente;
    private int idcliente;
    public Cliente(){}
    public Cliente(String nombre,String dni,String telefono,String correo,String estado, int idTipoCliente, int idcliente){
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.idTipoCliente = idTipoCliente;
        this.idcliente = idcliente;
    }

    public Cliente(String nombre,String dni,String telefono,String correo,String estado, int idTipoCliente){
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
}

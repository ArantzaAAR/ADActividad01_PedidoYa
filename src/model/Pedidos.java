package model;

import java.io.Serializable;

public class Pedidos implements Serializable {

    private static final Long serializableUID = 135L;
    private int id;
    private int clienteId;
    private String producto;
    private int cantidad;

    public Pedidos() {
    }

    public Pedidos(int id, int clienteId, String producto, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String prdocuto) {
        this.producto = prdocuto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %s, %s", id, clienteId, producto, cantidad);
    }

}

package com.speedfast.model;

import java.util.UUID;

public abstract class Pedido implements Pedidos{
    private final UUID idPedido;
    private final String direccionEntrega;

    public Pedido(String direccionEntrega) {
        this.idPedido = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void asignarRepartidor(){
        System.out.println("asignando repartidor");
    }
}

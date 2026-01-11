package com.speedfast.model;

public class PedidoComida extends Pedido {

    public PedidoComida(String direccionEntrega) {
        super(direccionEntrega);
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor con mochila termica");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("asignando a "+ nombreRepartidor +" quien posee una mochila térmica");
    }

}

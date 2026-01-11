package com.salmontt.model;

public class PedidoExpress extends Pedido{

    public PedidoExpress(String direccionEntrega) {
        super(direccionEntrega);
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor mas cercano");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("asignando a "+ nombreRepartidor +" quien es el mas cercano");
    }
}

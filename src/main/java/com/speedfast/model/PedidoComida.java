package com.speedfast.model;

public class PedidoComida extends Pedido {

    public PedidoComida(String direccionEntrega, float distanciaKm) {
        super(direccionEntrega, distanciaKm);
        setTipoPedido(TipoPedido.COMIDA);
        // always do:
        asignarRepartidor();
        calcularTiempoEntrega();
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor con mochila termica");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("asignando a "+ nombreRepartidor +" quien posee una mochila térmica. Tu pedido se demorara: " + getTiempoEstimadoEntregaMins() + " mins.");
    }

    @Override
    public void calcularTiempoEntrega() {
        // velocidad promedio: 120 km/h
        setTiempoEstimadoEntregaMins(15 + (2 * getDistanciaKm()));
    }
}

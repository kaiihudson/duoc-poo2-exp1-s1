package com.speedfast.model;

public class PedidoExpress extends Pedido{

    public PedidoExpress(String direccionEntrega, float distanciaKm) {
        super(direccionEntrega, distanciaKm);
        setTipoPedido(TipoPedido.EXPRESS);
        // always do:
        asignarRepartidor();
        calcularTiempoEntrega();
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor mas cercano");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("asignando a "+ nombreRepartidor +" quien es el mas cercano" + ". Tu pedido se demorara: " + getTiempoEstimadoEntregaMins() + " mins.");
    }

    @Override
    public void calcularTiempoEntrega() {
        float tiempo = 10;
        // para distancias grandes... velocidad promedio: 300 km/h
        if (getDistanciaKm() > 5){
            tiempo = tiempo + 5;
        }
        setTiempoEstimadoEntregaMins(tiempo);
    }
}

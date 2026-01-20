package com.speedfast.model;

import com.speedfast.model.interfaces.Cancelable;
import com.speedfast.model.interfaces.Despachable;
import com.speedfast.model.interfaces.Rastreable;

public class PedidoExpress extends Pedido implements Cancelable, Despachable, Rastreable {

    public PedidoExpress(String direccionEntrega, float distanciaKm) {
        super(direccionEntrega, distanciaKm);
        setTipoPedido(TipoPedido.EXPRESS);
        // always do:
        asignarRepartidor();
        calcularTiempoEntrega();
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando pedido " + getIdPedido());
    }

    @Override
    public void despachar() {
        System.out.println("Pedido \'" + getIdPedido() + "\' de tipo: " + getTipoPedido() + " ha salido a despacho con exito");
    }

    @Override
    public void verHistorial() {
        System.out.println("HISTORIAL");
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor mas cercano");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
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

package com.speedfast.model;

import com.speedfast.model.interfaces.Cancelable;
import com.speedfast.model.interfaces.Despachable;
import com.speedfast.model.interfaces.Rastreable;

public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable {

    public PedidoComida(String direccionEntrega, float distanciaKm) {
        super(direccionEntrega, distanciaKm);
        setTipoPedido(TipoPedido.COMIDA);
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
        System.out.println("asignando repartidor con mochila termica");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
        System.out.println("asignando a "+ nombreRepartidor +" quien posee una mochila térmica. Tu pedido se demorara: " + getTiempoEstimadoEntregaMins() + " mins.");
    }

    @Override
    public void calcularTiempoEntrega() {
        // velocidad promedio: 120 km/h
        setTiempoEstimadoEntregaMins(15 + (2 * getDistanciaKm()));
    }
}

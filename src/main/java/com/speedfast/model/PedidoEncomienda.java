package com.speedfast.model;

import com.speedfast.model.interfaces.Cancelable;
import com.speedfast.model.interfaces.Despachable;
import com.speedfast.model.interfaces.Rastreable;

public class PedidoEncomienda extends Pedido implements Cancelable, Despachable, Rastreable {
    private final int peso;
    private final String embalaje;

    public PedidoEncomienda(String direccionEntrega, float distanciaKm, int peso, String embalaje) {
        super(direccionEntrega, distanciaKm);
        this.peso = peso;
        this.embalaje = embalaje;
        setTipoPedido(TipoPedido.ENCOMIENDA);
        // always do:
        asignarRepartidor();
        calcularTiempoEntrega();
    }

    public int getPeso() {
        return peso;
    }

    public String getEmbalaje() {
        return embalaje;
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
        System.out.println("asignando repartidor capaz de manejar peso de: " + peso);
    }

    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
        System.out.println("asignando a "+ nombreRepartidor +" quien en capaz de manejar " + peso + ". Tu pedido se demorara: " + getTiempoEstimadoEntregaMins() + " mins.");
    }

    @Override
    public void calcularTiempoEntrega() {
        // velocidad promedio: 90km/h
        int formula = (int)(20 + (1.5f * getDistanciaKm()));
        setTiempoEstimadoEntregaMins((float) formula);
    }
}

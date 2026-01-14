package com.speedfast.model;

import java.util.UUID;

public abstract class Pedido implements Pedidos{
    private final UUID idPedido;
    private final String direccionEntrega;
    private final float distanciaKm;
    private float tiempoEstimadoEntregaMins;
    private TipoPedido tipoPedido;

    public Pedido(String direccionEntrega, float distanciaKm) {
        this.distanciaKm = distanciaKm;
        this.idPedido = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public float getDistanciaKm() {
        return distanciaKm;
    }

    public float getTiempoEstimadoEntregaMins() {
        return tiempoEstimadoEntregaMins;
    }

    public void setTiempoEstimadoEntregaMins(float tiempoEstimadoEntregaMins) {
        this.tiempoEstimadoEntregaMins = tiempoEstimadoEntregaMins;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public void asignarRepartidor(){
        System.out.println("asignando repartidor");
    }

    public void mostrarResumen(){
        System.out.println("LOGINFO: { Pedido: " + idPedido + ". Tipo: " + tipoPedido + ". Direccion: " + direccionEntrega + ". Distancia: " + distanciaKm + " Km }");
    }

    public abstract void calcularTiempoEntrega();
}

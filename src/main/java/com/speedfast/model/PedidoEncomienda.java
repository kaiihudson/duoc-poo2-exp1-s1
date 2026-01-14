package com.speedfast.model;

public class PedidoEncomienda extends Pedido{
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
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("asignando repartidor capaz de manejar peso de: " + peso);
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("asignando a "+ nombreRepartidor +" quien en capaz de manejar " + peso + ". Tu pedido se demorara: " + getTiempoEstimadoEntregaMins() + " mins.");
    }

    @Override
    public void calcularTiempoEntrega() {
        // velocidad promedio: 90km/h
        int formula = (int)(20 + (1.5f * getDistanciaKm()));
        setTiempoEstimadoEntregaMins((float) formula);
    }
}

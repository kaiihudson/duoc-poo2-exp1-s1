package com.salmontt.model;

public class PedidoEncomienda extends Pedido{
    private final int peso;
    private final String embalaje;

    public PedidoEncomienda(String direccionEntrega, int peso, String embalaje) {
        super(direccionEntrega);
        this.peso = peso;
        this.embalaje = embalaje;
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
        System.out.println("asignando a "+ nombreRepartidor +" quien en capaz de manejar" + peso);
    }
}

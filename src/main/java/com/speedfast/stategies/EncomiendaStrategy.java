package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;

public class EncomiendaStrategy implements StrategyImplementation {
    @Override
    public int calcularTiempo(float distancia) {
        return (int) (20 + (1.5f * distancia));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido de Encomienda");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignado a " + nombreRepartidor + " quien posee las capacidades para manejar el pedido");
    }
}

package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;

public class ComidaStrategy implements StrategyImplementation {
    @Override
    public int calcularTiempo(float distancia) {
        return ((int)distancia * 2) + 15;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido de Comida");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignado a " + nombreRepartidor + " quien posee una mochila termica");
    }
}

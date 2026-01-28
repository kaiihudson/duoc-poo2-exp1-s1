package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;
import com.speedfast.model.repartidor.Repartidor;

public class ComidaStrategy implements StrategyImplementation {
    @Override
    public int calcularTiempo(float distancia) {
        return (((int)distancia * 2) + 15) * 60000;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido de Comida");
    }

    @Override
    public void asignarRepartidor(Repartidor repartidor) {
        System.out.println("Asignado a " + repartidor.getNombre() + " quien posee una mochila termica");
    }
}

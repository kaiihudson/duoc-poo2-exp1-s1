package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;

public class ExpressStrategy implements StrategyImplementation {

    @Override
    public int calcularTiempo(float distancia) {
        if (distancia > 5) {
            return 15;
        } else {
            return 10;
        }
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido Express");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignado a " + nombreRepartidor + " quien es el mas cercano");
    }
}

package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;
import com.speedfast.model.repartidor.Repartidor;

public class ExpressStrategy implements StrategyImplementation {

    @Override
    public int calcularTiempo(float distancia) {
        if (distancia > 5) {
            return 90000;
        } else {
            return 60000;
        }
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido Express");
    }

    @Override
    public void asignarRepartidor(Repartidor repartidor) {
        System.out.println("Asignado a " + repartidor.getNombre() + " quien es el mas cercano");
    }
}

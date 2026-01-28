package com.speedfast.stategies;

import com.speedfast.interfaces.StrategyImplementation;
import com.speedfast.model.repartidor.Repartidor;

public class EncomiendaStrategy implements StrategyImplementation {
    @Override
    public int calcularTiempo(float distancia) {
        return ((int) (20 + (1.5f * distancia)) * 60000);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido de Encomienda");
    }

    @Override
    public void asignarRepartidor(Repartidor repartidor) {
        System.out.println("Asignado a " + repartidor.getNombre() + " quien posee las capacidades para manejar el pedido");
    }
}

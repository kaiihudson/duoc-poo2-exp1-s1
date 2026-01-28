package com.speedfast.interfaces;

import com.speedfast.model.repartidor.Repartidor;

public interface StrategyImplementation {
    int calcularTiempo(float distancia);
    void asignarRepartidor();
    void asignarRepartidor(Repartidor nombreRepartidor);
}

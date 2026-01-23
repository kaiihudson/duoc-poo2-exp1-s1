package com.speedfast.model;

import com.speedfast.interfaces.Cancelable;
import com.speedfast.interfaces.Despachable;
import com.speedfast.interfaces.Rastreable;
import com.speedfast.interfaces.StrategyImplementation;

public class Express extends Pedido implements Cancelable, Despachable, Rastreable {
    public Express(StrategyImplementation estrategia) {
        super(estrategia);
    }
    @Override
    public void cancelar() {
        super.historial.add("Pedido Cancelado");
        if (!activo) {
            super.historial.add("Se intento desactivar un pedido inactivo");
        } else {
            activo = false;
        }
    }

    @Override
    public void reactivar() {
        super.historial.add("Pedido Reactivado");
        if (activo) {
            super.historial.add("Se intento reactivar un pedido activo");
        } else {
            activo = true;
        }
    }

    @Override
    public void despachar(String repartidorAsignado) {
        estrategia.asignarRepartidor(repartidorAsignado);
        this.repartidor = repartidorAsignado;
        if (despachado) {
            super.historial.add("Se intento despachar un pedido ya despachado");
        } else {
            despachado = true;
            super.historial.add("Pedido despachado a cargo de " + repartidor);
        }
    }

    @Override
    public void verHistorial() {
        super.mostrarHistorial();
    }
    @Override
    public void mostrarResumen() {
        System.out.println(
                "LOGINFO: { Pedido: " + idPedido +
                        ". Tipo: Express. Direccion: " + direccion +
                        ". Distancia: " + distancia + " Km. Tiempo estimado: " + tiempoMs +
                        " }");
    }
}

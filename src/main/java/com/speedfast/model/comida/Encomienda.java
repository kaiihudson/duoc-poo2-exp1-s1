package com.speedfast.model.comida;

import com.speedfast.interfaces.*;
import com.speedfast.model.repartidor.Repartidor;

public class Encomienda extends Pedido implements Asignable, Cancelable, Despachable, Rastreable {
    String embalaje;
    float peso;

    public Encomienda(StrategyImplementation estrategia, String embalaje, float peso) {
        super(estrategia);
        this.embalaje = embalaje;
        this.peso = peso;
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
    public void despachar() {
        if (asignado) {
            if (despachado) {
                super.historial.add("Se intento despachar un pedido ya despachado");
            } else {
                despachado = true;
                super.historial.add("Pedido despachado a cargo de " + repartidor.getNombre());
            }
        } else {
            super.historial.add("Se intento despachar un pedido sin asignar");
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
                        ". Tipo: Encomienda. Direccion: " + direccion +
                        ". Distancia: " + distancia + " Km. Tiempo estimado: " + tiempoMs +
                        " Peso: "+ peso +
                        ". Embajale: "+ embalaje +" }");
    }

    @Override
    public void asignar(Repartidor repartidor) {
        estrategia.asignarRepartidor(repartidor);
        this.repartidor = repartidor;
        if (!asignado) {
            asignado = true;
        }
    }
}

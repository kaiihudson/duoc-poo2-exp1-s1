package com.speedfast.model;

import com.speedfast.interfaces.Auditable;
import com.speedfast.interfaces.StrategyImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Pedido implements Auditable {
    protected UUID idPedido;
    protected String direccion;
    protected float distancia;
    protected int tiempoMs;
    protected StrategyImplementation estrategia;
    protected String repartidor;
    protected List<String> historial = new ArrayList<>();
    boolean activo = true;
    boolean despachado = false;

    public Pedido(StrategyImplementation estrategia) {
        this.idPedido = UUID.randomUUID();
        this.estrategia = estrategia;

        this.historial.add("Pedido creado con id: " + this.getClass().getSimpleName() + " " + idPedido);
        if (estrategia != null) {
            estrategia.asignarRepartidor();
        }
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
        this.tiempoMs = estrategia.calcularTiempo(distancia);
    }

    @Override
    public abstract void mostrarResumen();

    @Override
    public void mostrarHistorial() {
        for(String registro: historial){
            System.out.println(registro);
        }
    }
}

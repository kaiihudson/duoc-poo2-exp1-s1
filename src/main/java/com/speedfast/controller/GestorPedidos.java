package com.speedfast.controller;

import com.speedfast.interfaces.*;
import com.speedfast.model.comida.Comida;
import com.speedfast.model.comida.Encomienda;
import com.speedfast.model.comida.Express;
import com.speedfast.model.comida.Pedido;
import com.speedfast.model.repartidor.Repartidor;
import com.speedfast.stategies.ComidaStrategy;
import com.speedfast.stategies.EncomiendaStrategy;
import com.speedfast.stategies.ExpressStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GestorPedidos {
    private final List<Cancelable> cancelables = new ArrayList<>();
    private final List<Despachable> despachables = new ArrayList<>();
    private final List<Rastreable> rastreables = new ArrayList<>();
    private final List<Auditable> auditables = new ArrayList<>();
    private final List<Asignable> asignables = new ArrayList<>();
    private final List<Repartidor> repartidores = new ArrayList<>();
    private ExecutorService ejecutor;

    public Repartidor crearRepartidor(String nombre){
        Repartidor r = new Repartidor(nombre);
        repartidores.add(r);
        return r;
    }

    public int getCurrentRepartidores(){
        return repartidores.size();
    }

    public ExecutorService crearDispatcher(){
        ejecutor = Executors.newFixedThreadPool(getCurrentRepartidores());
        return ejecutor;
    }

    public void killExecutor(){
        ejecutor.shutdownNow();
    }

    public ExecutorService regenerateDispatcher(){
        killExecutor();
        ejecutor = Executors.newFixedThreadPool(getCurrentRepartidores());
        return ejecutor;
    }

    public UUID crearPedidoComida(String direccion){
        Comida comida = new Comida(new ComidaStrategy());
        comida.setDireccion(direccion);
        // from here onwards it's DEMO
        comida.setDistancia(10);
        // end DEMO
        cancelables.add(comida);
        rastreables.add(comida);
        auditables.add(comida);
        asignables.add(comida);
        // return for trace
        return comida.getIdPedido();
    }

    public UUID crearPedidoExpress(String direccion){
        Express express = new Express(new ExpressStrategy());
        express.setDireccion(direccion);
        // from here onwards it's DEMO
        express.setDistancia(2);
        // end DEMO
        cancelables.add(express);
        rastreables.add(express);
        auditables.add(express);
        asignables.add(express);
        return express.getIdPedido();
    }

    public UUID crearPedidoEncomienda(String direccion, String embalaje, float peso){
        Encomienda encomienda = new Encomienda(new EncomiendaStrategy(), embalaje, peso);
        encomienda.setDireccion(direccion);
        // from here onwards it's DEMO
        encomienda.setDistancia(100);
        // end DEMO
        cancelables.add(encomienda);
        rastreables.add(encomienda);
        auditables.add(encomienda);
        asignables.add(encomienda);
        return encomienda.getIdPedido();
    }

    public void asignarRepartidor(UUID idPedido, Repartidor repartidor){
        for (Asignable a: asignables) {
            if (((Pedido) a).getIdPedido() == idPedido){
                a.asignar(repartidor);
                repartidor.addPedido((Despachable) a);
                asignables.remove(a);
                despachables.add((Despachable) a);
                break;
            }
        }
    }

    public void despacharPedido(UUID idPedido){
        for (Despachable d: despachables){
            if (((Pedido) d).getIdPedido() == idPedido){
                d.despachar();
                despachables.remove(d);
                break;
            }
        }
    }

    public void ejecutarDespacho(UUID idPedido, Repartidor r){
        despacharPedido(idPedido);
        ejecutor.execute(r);
    }

    public void cancelarPedido(UUID idPedido){
        for (Cancelable c: cancelables){
            if (((Pedido) c).getIdPedido() == idPedido){
                c.cancelar();
                cancelables.remove(c);
                break;
            }
        }
    }

    public void mostrarTodoDato(){
        for (Auditable a: auditables) {
            System.out.println(a.getClass().getSimpleName());
            a.mostrarResumen();
        }
    }

    public void mostrarTodoHistorial(){
        for (Rastreable r: rastreables){
            System.out.println(r.getClass().getSimpleName());
            r.verHistorial();
        }
    }

    public void despacharTodos(){
        for (Despachable d: despachables){
            d.despachar();
        }
    }

    public void cancelarTodos(){
        for (Cancelable c: cancelables) {
            c.cancelar();
        }
    }
}

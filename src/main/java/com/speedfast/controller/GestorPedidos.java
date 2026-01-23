package com.speedfast.controller;

import com.speedfast.interfaces.Auditable;
import com.speedfast.interfaces.Cancelable;
import com.speedfast.interfaces.Despachable;
import com.speedfast.interfaces.Rastreable;
import com.speedfast.model.Comida;
import com.speedfast.model.Encomienda;
import com.speedfast.model.Express;
import com.speedfast.stategies.ComidaStrategy;
import com.speedfast.stategies.EncomiendaStrategy;
import com.speedfast.stategies.ExpressStrategy;

import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {
    List<Cancelable> cancelables = new ArrayList<>();
    List<Despachable> despachables = new ArrayList<>();
    List<Rastreable> rastreables = new ArrayList<>();
    List<Auditable> auditables = new ArrayList<>();

    public void crearPedidoComida(String direccion){
        Comida comida = new Comida(new ComidaStrategy());
        comida.setDireccion(direccion);
        // from here onwards it's DEMO
        comida.setDistancia(10);
        // end DEMO
        cancelables.add(comida);
        despachables.add(comida);
        rastreables.add(comida);
        auditables.add(comida);
    }

    public void crearPedidoExpress(String direccion){
        Express express = new Express(new ExpressStrategy());
        express.setDireccion(direccion);
        // from here onwards it's DEMO
        express.setDistancia(2);
        // end DEMO
        cancelables.add(express);
        despachables.add(express);
        rastreables.add(express);
        auditables.add(express);
    }

    public void crearPedidoEncomienda(String direccion, String embalaje, float peso){
        Encomienda encomienda = new Encomienda(new EncomiendaStrategy(), embalaje, peso);
        encomienda.setDireccion(direccion);
        // from here onwards it's DEMO
        encomienda.setDistancia(100);
        // end DEMO
        cancelables.add(encomienda);
        despachables.add(encomienda);
        rastreables.add(encomienda);
        auditables.add(encomienda);
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
            d.despachar("SUPER-REPARTIDOR");
        }
    }

    public void cancelarTodos(){
        for (Cancelable c: cancelables) {
            c.cancelar();
        }
    }

}

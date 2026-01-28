package com.speedfast.app;

import com.speedfast.controller.GestorPedidos;
import com.speedfast.model.repartidor.Repartidor;

import java.util.UUID;

public class Main {
    static void main(String[] args) {

        GestorPedidos gestor = new GestorPedidos();

        // crear repartidores.
        Repartidor rep = gestor.crearRepartidor("Sebastian");
        Repartidor rep2 = gestor.crearRepartidor("ebastianS");
        Repartidor rep3 = gestor.crearRepartidor("bastianSe");

        // instanciamos el ejecutor
        gestor.crearDispatcher();

        // crear instancias de los objetos
        UUID comida1 = gestor.crearPedidoComida("calleComida1");
        UUID comida2 = gestor.crearPedidoComida("calleComida2");
        UUID encomienda1 = gestor.crearPedidoEncomienda("calleEncomienda2", "papel", 2);
        UUID encomienda2 = gestor.crearPedidoEncomienda("calleEncomienda2", "bolsa", 10);
        UUID express1 = gestor.crearPedidoExpress("calleExpress3");
        UUID express2 = gestor.crearPedidoExpress("calleExpress2");
        UUID sobrante1 = gestor.crearPedidoComida("sobras1");
        UUID sobrante2 = gestor.crearPedidoExpress("sobras2");

        // verificar funcionamiento
        System.out.println("=".repeat(30));
        gestor.mostrarTodoDato();
        // asignar pedidos a repartidores (podria hacerse en base a un sistema)
        System.out.println("=".repeat(30));
        gestor.asignarRepartidor(comida1, rep);
        gestor.asignarRepartidor(comida2, rep);
        gestor.asignarRepartidor(encomienda1, rep2);
        gestor.asignarRepartidor(encomienda2, rep2);
        gestor.asignarRepartidor(express1, rep3);
        gestor.asignarRepartidor(express2, rep3);

        // despachar como hilo
        System.out.println("=".repeat(30));
        gestor.ejecutarDespacho(comida1, rep);
        gestor.ejecutarDespacho(encomienda2, rep2);
        gestor.ejecutarDespacho(express1, rep3);

        // cancelar sobrantes
        System.out.println("=".repeat(30));
        gestor.cancelarPedido(sobrante1);
        gestor.cancelarPedido(sobrante2);

        // mostrar todo el historial
        System.out.println("=".repeat(30));
        gestor.mostrarTodoHistorial();

        // kill instance
        gestor.killExecutor();
    }
}

package com.speedfast.app;

import com.speedfast.controller.GestorPedidos;

public class Main {
    static void main(String[] args) {
        GestorPedidos gestor = new GestorPedidos();
        // crear instancias de los objetos
        gestor.crearPedidoComida("calle1");
        gestor.crearPedidoEncomienda("calle2", "papel", 2);
        gestor.crearPedidoExpress("calle3");

        // verificar funcionamiento
        System.out.println("=".repeat(30));
        gestor.mostrarTodoDato();
        System.out.println("=".repeat(30));
        gestor.despacharTodos();
        System.out.println("=".repeat(30));
        gestor.cancelarTodos();
        System.out.println("=".repeat(30));
        gestor.mostrarTodoHistorial();
    }
}

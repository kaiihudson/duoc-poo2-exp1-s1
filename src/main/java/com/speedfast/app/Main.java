package com.speedfast.app;

import com.speedfast.model.*;

public class Main {
    static void main() {
        // comida
        System.out.println("[Comida]");
        PedidoComida pedidoComida = new PedidoComida("casa1");
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("nombre1");
        // encomienda
        System.out.println("[Encomienda]");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("casa1", 2, "paquete");
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("nombre2");
        // express
        System.out.println("[Express]");
        PedidoExpress pedidoExpress = new PedidoExpress("casa3");
        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("nombre3");

    }
}

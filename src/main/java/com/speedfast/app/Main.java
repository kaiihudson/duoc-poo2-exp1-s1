package com.speedfast.app;

import com.speedfast.model.*;

public class Main {
    static void main() {
        // comida
        System.out.println("[Comida]");
        PedidoComida pedidoComida = new PedidoComida("casa1", 10);
        pedidoComida.mostrarResumen();
        pedidoComida.asignarRepartidor("nombre1");
        // encomienda
        System.out.println("[Encomienda]");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("casa1", 110, 2, "paquete");
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.asignarRepartidor("nombre2");
        // express corto
        System.out.println("[Express Corto]");
        PedidoExpress pedidoExpressCorto = new PedidoExpress("casa3", 3);
        pedidoExpressCorto.mostrarResumen();
        pedidoExpressCorto.asignarRepartidor("nombre3");
        // express largo
        System.out.println("[Express Largo]");
        PedidoExpress pedidoExpressLargo = new PedidoExpress("casa3", 15);
        pedidoExpressLargo.mostrarResumen();
        pedidoExpressLargo.asignarRepartidor("nombre4");
    }
}

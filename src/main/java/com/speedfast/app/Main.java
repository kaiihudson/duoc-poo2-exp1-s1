package com.speedfast.app;

import com.speedfast.model.*;

public class Main {
    static void main() {
        // comida
        System.out.println("[Comida]");
        PedidoComida pedidoComida = new PedidoComida("casa1", 10);
        pedidoComida.asignarRepartidor("nombre1");
        pedidoComida.mostrarResumen();
        // encomienda
        System.out.println("[Encomienda]");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("casa1", 110, 2, "paquete");
        pedidoEncomienda.asignarRepartidor("nombre2");
        pedidoEncomienda.mostrarResumen();
        // express corto
        System.out.println("[Express Corto]");
        PedidoExpress pedidoExpressCorto = new PedidoExpress("casa3", 3);
        pedidoExpressCorto.asignarRepartidor("nombre3");
        pedidoExpressCorto.mostrarResumen();
        // express largo
        System.out.println("[Express Largo]");
        PedidoExpress pedidoExpressLargo = new PedidoExpress("casa3", 15);
        pedidoExpressLargo.asignarRepartidor("nombre4");
        pedidoExpressLargo.mostrarResumen();

        //funcionalidades s3
        System.out.println("[Verificacion de funcionamiento]");
        pedidoComida.despachar();
        pedidoEncomienda.cancelar();
        pedidoExpressCorto.verHistorial();
    }
}

package com.speedfast.model.repartidor;

import com.speedfast.interfaces.Despachable;
import com.speedfast.model.comida.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Repartidor implements Runnable {
    private final UUID idRepartidor;
    private final String nombre;
    private final List<Despachable> listaPedidos = new ArrayList<>();

    public Repartidor(String nombre) {
        this.idRepartidor = UUID.randomUUID();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void addPedido(Despachable d) {
        listaPedidos.add(d);
    }

    @Override
    public void run() {
        while (!listaPedidos.isEmpty()) {
            Pedido p = (Pedido) listaPedidos.getFirst();
            try {
                System.out.println("Despachando pedido " + p.getIdPedido() + ". Tiempo estimado de espera: " + p.getTiempoMs()/60000 +" mins.");
                // simula tiempo de entrega with a minute delay inbetween
                Thread.sleep(p.getTiempoMs() + 60000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                listaPedidos.remove(p);
                System.out.println("Despacho interrumpido");
            }
        }

    }
}

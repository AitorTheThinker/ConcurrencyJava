package barberosdurmientes4threadmal;

import java.util.LinkedList;
import java.util.Queue;

public class BarberoDurmiendoMainThread {

    private static final int NUM_SILLAS = 5;

    public static void main(String[] args) {
        Object lock = new Object();
        Queue<Integer> clientesEsperando = new LinkedList<>();
        int sillasOcupadas = 0;

        BarberoThread barbero = new BarberoThread(lock, clientesEsperando);
        Thread hiloBarbero = new Thread(barbero);
        hiloBarbero.start();

        for (int i = 1; i <= 10; i++) {
            ClienteThread cliente = new ClienteThread(lock, clientesEsperando, sillasOcupadas, i, NUM_SILLAS);
            Thread hiloCliente = new Thread(cliente);
            hiloCliente.start();
            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package comensal;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {
    private int id;
    private Semaphore[] tenedores;
    private int numComensales;

    public Comensal(int id, Semaphore[] tenedores, int numComensales) {
        this.id = id;
        this.tenedores = tenedores;
        this.numComensales = numComensales;
    }

    public void run() {
        while (true) {
            // El comensal coge el tenedor a su izquierda
            tenedores[id].acquireUninterruptibly();
            System.out.println("Comensal " + id + " ha cogido el tenedor izquierdo.");

            // El comensal intenta coger el tenedor a su derecha
            boolean tenedorDerechaDisponible = tenedores[(id + 1) % numComensales].tryAcquire();
            if (tenedorDerechaDisponible) {
                // Ambos tenedores están disponibles, el comensal puede comer
                System.out.println("Comensal " + id + " ha cogido el tenedor derecho y está comiendo.");
                try {
                    Thread.sleep(2000); // simulación del tiempo que tarda el comensal en comer
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Comensal " + id + " ha terminado de comer y suelta ambos tenedores.");
                tenedores[id].release();
                tenedores[(id + 1) % numComensales].release();
                break;
            } else {
                // El tenedor a la derecha no está disponible, el comensal suelta el tenedor a la izquierda
                tenedores[id].release();
                System.out.println("Comensal " + id + " ha soltado el tenedor izquierdo.");
                try {
                    Thread.sleep(1000); // simulación del tiempo que tarda el comensal en pensar antes de volver a intentar comer
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}


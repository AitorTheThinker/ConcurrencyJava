package comensal;

import java.util.concurrent.Semaphore;

public class ComensalElegante {
    public static void main(String[] args) {
        final int NUM_COMENSALES = 6;
        Semaphore[] tenedores = new Semaphore[NUM_COMENSALES];

        // Inicializar los semáforos de los tenedores
        for (int i = 0; i < NUM_COMENSALES; i++) {
            tenedores[i] = new Semaphore(1);
        }

        // Crear los hilos para los comensales
        Thread[] comensales = new Thread[NUM_COMENSALES];
        for (int i = 0; i < NUM_COMENSALES; i++) {
            comensales[i] = new Thread(new Comensal(i, tenedores, NUM_COMENSALES));
        }

        // Ejecutar los hilos para los comensales
        for (int i = 0; i < NUM_COMENSALES; i++) {
            comensales[i].start();
        }
    }
}


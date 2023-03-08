package barberosdurmientes4threadmal;

import java.util.Queue;
import java.util.Random;

public class BarberoThread extends Thread {
    private GestorSillas gestorSillas;
    private boolean barberiaAbierta;

    public BarberoThread(GestorSillas g) {
        gestorSillas = g;
        barberiaAbierta = true;
    }

    public BarberoThread(Object lock, Queue<Integer> clientesEsperando) {
		// TODO Auto-generated constructor stub
	}

	public void cerrarBarberia() {
        this.barberiaAbierta = false;
    }

    @Override
    public void run() {
        while (barberiaAbierta) {
            int posSillaClienteSinAtender;
            posSillaClienteSinAtender = this.gestorSillas.getSiguienteCliente();
            if (posSillaClienteSinAtender == -1) {
                esperarTiempoAzar(3);
            } else {
                System.out.println("Barbero atendiendo silla:" + posSillaClienteSinAtender);
                esperarTiempoAzar(3);
                this.gestorSillas.liberarSilla(posSillaClienteSinAtender);
            }
        }
    }

    public static void esperarTiempoAzar(int max) {
        Random generador = new Random();
        /* Se calculan unos milisegundos al azar*/
        int msgs = (1 + generador.nextInt(max)) * 1000;
        try {
            Thread.sleep(msgs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

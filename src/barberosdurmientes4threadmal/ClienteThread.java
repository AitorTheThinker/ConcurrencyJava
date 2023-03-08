package barberosdurmientes4threadmal;

import java.util.Queue;

public class ClienteThread extends Thread {
    private GestorSillas gestorSillas;
    private int numSillas;

    public ClienteThread(GestorSillas g, int numSillas) {
        this.gestorSillas = g;
        this.numSillas = numSillas;
    }
    public ClienteThread(Object lock, Queue<Integer> clientesEsperando, int sillasOcupadas, int i, int numSillas) {
        this.gestorSillas = new GestorSillas(numSillas);
        this.numSillas = numSillas;
    }


    public void entrarEnBarberia() {
        int posSillaLibre = this.gestorSillas.getPosSillaLibre();
        if (posSillaLibre == -1) {
            System.out.println("No había sillas libres, me marcho");
            return;
        }
        System.out.println("Soy el cliente " + this.numSillas + " y me siento en la silla: " + posSillaLibre);
    }



    @Override
    public void run() {
        entrarEnBarberia();
        synchronized (this.gestorSillas) {
            this.gestorSillas.notifyAll();
        }
        while (true) {
            synchronized (this.gestorSillas) {
                int posSilla = this.gestorSillas.getSiguienteCliente();
                if (posSilla != -1) {
                    System.out.println("Cliente atendido en la silla: " + posSilla);
                    this.gestorSillas.liberarSilla(posSilla);
                    break;
                } else if (this.gestorSillas.getPosSillaLibre() == this.numSillas) {
                    System.out.println("No hay más clientes, me voy");
                    break;
                } else {
                    try {
                        System.out.println("No hay sillas libres, esperando...");
                        this.gestorSillas.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

package puenterunnable;

import java.util.concurrent.Semaphore;

public class Peaton implements Runnable {
    private int id;
    private Semaphore semaforoPuente;
    private Semaphore semaforoPeatones;
    
    public Peaton(int id, Semaphore semaforoPuente, Semaphore semaforoPeatones) {
        this.id = id;
        this.semaforoPuente = semaforoPuente;
        this.semaforoPeatones = semaforoPeatones;
    }
    public Peaton(int id) {
        this.id = id;
    }

    public void run() {
        try {
            semaforoPeatones.acquire();
            semaforoPuente.acquire();
            System.out.println("Peaton " + id + " cruzando el puente");
            Thread.sleep(2000); // simulación del tiempo que tarda el peatón en cruzar el puente
            semaforoPuente.release();
            System.out.println("Peaton " + id + " ha salido del puente");
            semaforoPeatones.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

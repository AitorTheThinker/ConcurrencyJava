package puenterunnable;

import java.util.concurrent.Semaphore;

public class Vehiculo implements Runnable {
    private int id;
    private Semaphore semaforoPuente;
    private Semaphore semaforoVehiculos;

    public Vehiculo(int id, Semaphore semaforoPuente, Semaphore semaforoVehiculos) {
        this.id = id;
        this.semaforoPuente = semaforoPuente;
        this.semaforoVehiculos = semaforoVehiculos;
    }

    public void run() {
        try {
            semaforoVehiculos.acquire();
            semaforoPuente.acquire();
            System.out.println("Vehiculo " + id + " cruzando el puente");
            Thread.sleep(1000); // simulación del tiempo que tarda el vehículo en cruzar el puente
            semaforoPuente.release();
            System.out.println("Vehiculo " + id + " ha salido del puente");
            semaforoVehiculos.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


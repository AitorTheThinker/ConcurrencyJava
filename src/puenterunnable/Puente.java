package puenterunnable;

import java.util.concurrent.Semaphore;

public class Puente {
    private static final int NUM_VEHICULOS = 10;
    private static final int NUM_PEATONES = 20;
    private static final int CAPACIDAD_PUENTE = 5;

    private static Semaphore semaforoPuente;
    private static Semaphore semaforoVehiculos;
    private static Semaphore semaforoPeatones;

    public static void main(String[] args) {
        semaforoPuente = new Semaphore(CAPACIDAD_PUENTE);
        semaforoVehiculos = new Semaphore(1);
        semaforoPeatones = new Semaphore(1);
        
        Thread[] vehiculos = new Thread[NUM_VEHICULOS];
        for (int i = 0; i < NUM_VEHICULOS; i++) {
            vehiculos[i] = new Thread(new Vehiculo(i + 1, semaforoPuente, semaforoVehiculos));
            vehiculos[i].start();
        }


        Thread[] peatones = new Thread[NUM_PEATONES];
        for (int i = 0; i < NUM_PEATONES; i++) {
            peatones[i] = new Thread(new Peaton(i + 1));
            peatones[i].start();
        }
    }
}

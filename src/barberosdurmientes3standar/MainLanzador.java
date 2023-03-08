package barberosdurmientes3standar;

public class MainLanzador {

    public static void main(String[] args) throws InterruptedException {
            int MAX_BARBEROS = 2;
            int MAX_SILLAS   = 3;
            int MAX_CLIENTES = 1000;
            Barbero[] barberos;
            Thread[]  hilos;

            barberos=new Barbero[MAX_BARBEROS];
            hilos   =new Thread [MAX_BARBEROS];

            GestorSillas gestorSillas=new GestorSillas(MAX_SILLAS);

            for (int i=0; i<MAX_BARBEROS; i++){
                    barberos[i]=new Barbero(gestorSillas);
                    hilos[i]   =new Thread(barberos[i]);

                    hilos[i].start();
            } //Fin del for


            for (int i=0; i< MAX_CLIENTES; i++){
                    Cliente c=new Cliente(gestorSillas);
                    c.entrarEnBarberia();
            }
            Barbero.esperarTiempoAzar(30);
            /* La jornada ha terminado, "cerramos" los barberos*/
            for (int i=0; i<MAX_BARBEROS; i++){
                    barberos[i].cerrarBarberia();
                    hilos[i].join();
            }
            System.out.println("Barberia cerrada.");
    } 
} 
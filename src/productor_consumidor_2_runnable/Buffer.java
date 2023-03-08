package productor_consumidor_2_runnable;

public class Buffer {
    private int[] array = new int[10];
    private int contador = 0;
    private int posicion = 0;

    public synchronized void poner(int numero) {
        while (contador == array.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        array[posicion] = numero;
        System.out.println("El productor ha puesto el número " + numero);
        contador++;
        posicion = (posicion + 1) % array.length;
        
        notifyAll();
    }

    public synchronized int sacar() {
        while (contador == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int numero = array[(posicion - contador + array.length) % array.length];
        System.out.println("El consumidor ha sacado el número " + numero);
        contador--;
        notifyAll();
        
        return numero;
    }
}

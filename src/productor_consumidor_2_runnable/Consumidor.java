package productor_consumidor_2_runnable;

import java.util.Random;

public class Consumidor implements Runnable {
    private Buffer buffer;
    private Random random = new Random();

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int numero = buffer.sacar();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


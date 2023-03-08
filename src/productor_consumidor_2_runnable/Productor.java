package productor_consumidor_2_runnable;

import java.util.Random;

public class Productor implements Runnable {
	
    private Buffer buffer;
    private Random random = new Random();

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int numero = random.nextInt(10) + 1;
            buffer.poner(numero);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

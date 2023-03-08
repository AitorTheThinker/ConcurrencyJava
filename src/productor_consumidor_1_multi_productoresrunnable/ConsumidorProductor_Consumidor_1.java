package productor_consumidor_1_multi_productoresrunnable;


public class ConsumidorProductor_Consumidor_1 implements Runnable {
    private BufferProductor_Consumidor_1 buffer;
    private int id;
    
    public ConsumidorProductor_Consumidor_1(BufferProductor_Consumidor_1 buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }
    
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                int value = buffer.get();
                System.out.println("Consumidor " + id + " ha consumido el valor " + value);
                Thread.sleep((long)(Math.random() * 1000));
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}



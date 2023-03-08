package productor_consumidor_1_multi_productoresrunnable;

public class ProductorProductor_Consumidor_1 implements Runnable {
    private BufferProductor_Consumidor_1 buffer;
    private int id;
    
    public ProductorProductor_Consumidor_1(BufferProductor_Consumidor_1 buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }
    
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                int value = (int)(Math.random() * 100);
                buffer.put(value);
                System.out.println("Productor " + id + " ha producido el valor " + value);
                Thread.sleep((long)(Math.random() * 1000));
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}



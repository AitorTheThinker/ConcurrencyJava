package productor_consumidor_1_multi_productoresrunnable;

public class BufferProductor_Consumidor_1 {
	    private int[] buffer;
	    private int count;
	    private int size;
	    private int putIndex;
	    private int getIndex;
	    private Object lock;
	    
	    public BufferProductor_Consumidor_1(int size) {
	        this.buffer = new int[size];
	        this.count = 0;
	        this.size = size;
	        this.putIndex = 0;
	        this.getIndex = 0;
	        this.lock = new Object();
	    }
	    
	    public void put(int value) throws InterruptedException {
	        synchronized(lock) {
	            while(count == size) {
	                lock.wait();
	            }
	            buffer[putIndex] = value;
	            putIndex = (putIndex + 1) % size;
	            count++;
	            lock.notifyAll();
	        }
	    }
	    
	    public int get() throws InterruptedException {
	        synchronized(lock) {
	            while(count == 0) {
	                lock.wait();
	            }
	            int value = buffer[getIndex];
	            getIndex = (getIndex + 1) % size;
	            count--;
	            lock.notifyAll();
	            return value;
	        }
	    }
	}
package lectura_escritura_runnable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Database {
	  private String data;
	  private int readers;
	  private boolean writing;
	  private Lock lock;
	  private Condition canRead;
	  private Condition canWrite;

	  public Database() {
	    data = "";
	    readers = 0;
	    writing = false;
	    lock = new ReentrantLock();
	    canRead = lock.newCondition();
	    canWrite = lock.newCondition();
	  }

	  public void read() throws InterruptedException {
	    lock.lock();
	    try {
	      while (writing) {
	        canRead.await();
	      }
	      readers++;
	      System.out.println(Thread.currentThread().getName() + " reads " + data);
	    } finally {
	      readers--;
	      canWrite.signal();
	      lock.unlock();
	    }
	  }

	  public void write(String newData) throws InterruptedException {
	    lock.lock();
	    try {
	      while (writing || readers > 0) {
	        canWrite.await();
	      }
	      writing = true;
	      data = newData;
	      System.out.println(Thread.currentThread().getName() + " writes " + data);
	    } finally {
	      writing = false;
	      canRead.signalAll();
	      canWrite.signal();
	      lock.unlock();
	    }
	  }
	}

package lectura_escritura_runnable;

public class lectura_escritura_Main {
	public static void main(String[] args) {
	    Database database = new Database();

	    Thread[] readers = new Thread[3];
	    for (int i = 0; i < readers.length; i++) {
	      readers[i] = new Thread(new ReaderWriter(database, true));
	      readers[i].start();
	    }

	    Thread[] writers = new Thread[3];
	    for (int i = 0; i < writers.length; i++) {
	      writers[i] = new Thread(new ReaderWriter(database, false));
	      writers[i].start();
	    }
	  }
}

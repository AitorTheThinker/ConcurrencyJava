package lectura_escritura_runnable;

class ReaderWriter implements Runnable {
	  private Database database;
	  private boolean isReader;

	  public ReaderWriter(Database database, boolean isReader) {
	    this.database = database;
	    this.isReader = isReader;
	  }

	  public void run() {
	    try {
	      if (isReader) {
	        database.read();
	      } else {
	        database.write(Thread.currentThread().getName() + " writes something");
	      }
	    } catch (InterruptedException e) {
	      System.out.println(e.getMessage());
	    }
	  }
	}


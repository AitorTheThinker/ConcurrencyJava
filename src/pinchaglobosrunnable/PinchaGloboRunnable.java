package pinchaglobosrunnable;

public class PinchaGloboRunnable implements Runnable{
	
    private GlobosRunnable g;
    private int numero;
    
	public PinchaGloboRunnable(GlobosRunnable pg, int pnumero) {
	    g = pg;
	    numero = pnumero;
	    Thread t = new Thread(this);
	    t.setName("PG" + numero);
	    t.start();
	}

	@Override
	public void run() {
	    int num;
	    boolean nohaymas;
	    do {
	        try {
	            Thread.sleep((int) (Math.random() * 5000));
	        } catch (Exception e) {
	        }
	        
	        nohaymas = g.pincho();
	    } while (!nohaymas);
	} 

}
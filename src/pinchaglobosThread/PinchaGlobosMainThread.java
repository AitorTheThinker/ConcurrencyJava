package pinchaglobosThread;

public class PinchaGlobosMainThread {

	public static void main(String[] args) {
		GlobosThread globos = new GlobosThread();
		 
       
        for (int i = 1; i <= 5; i++) {
            HinchaGloboThread hg = new HinchaGloboThread(globos, i);
            PinchaGloboThread pg = new PinchaGloboThread(globos, i);
            hg.start();
            pg.start();
        }
	}
}

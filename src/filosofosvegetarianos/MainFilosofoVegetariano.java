package filosofosvegetarianos;

public class MainFilosofoVegetariano {
	 public static void main(String[] args) {
	        int numFilosofos = 5;
	        Tenedor[] tenedores = new Tenedor[numFilosofos];
	        for (int i = 0; i < numFilosofos; i++) {
	            tenedores[i] = new Tenedor(i);
	        }

	        FilosofoVegetariano[] filosofos = new FilosofoVegetariano[numFilosofos];
	        for (int i = 0; i < numFilosofos; i++) {
	            filosofos[i] = new FilosofoVegetariano(i, tenedores[i], tenedores[(i + 1) % numFilosofos]);
	            Thread t = new Thread(filosofos[i]);
	            t.start();
	        }
	    }
}

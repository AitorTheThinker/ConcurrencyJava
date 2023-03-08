package barberosdurmientes2git;


public class Barbero extends Thread {

	private Barberia laBarberia;

	public Barbero(Barberia laBarberia) {
		this.laBarberia = laBarberia;
	}

	public void run() {
		while (true) {
			try {
				laBarberia.esperarCliente();
				// Cortar pelo
				Thread.sleep(5000);
				laBarberia.acabarCorte();
				// Decansa un poco
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			;
		}
	}
}
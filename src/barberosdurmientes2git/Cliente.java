package barberosdurmientes2git;


public class Cliente extends java.lang.Thread {

	private Barberia laBarberia;
	private int clienteId;
	private boolean cortePelo = false;

	public Cliente(Barberia laBarberia, int clienteId) {
		this.laBarberia = laBarberia;
		this.clienteId = clienteId;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				cortePelo = laBarberia.entrar(clienteId);
				// Cortar pelo
				if (cortePelo) {
					// Espero hasta que me crezca el pelo
					Thread.sleep(25000);
				} else {
					// Espero y lo vuelvo a intentar
					Thread.sleep(4000);
				}
			} catch (InterruptedException e) {
			}
			;
		}
	}
}

package barberosdurmientes2git;


public class LaBarberia {

	public static void main(String[] args) {
		final int nSillas = 4;
		final int nClientes = 10;
		
		Barberia laBarberia = new Barberia(nSillas);
		Barbero elBarbero = new Barbero(laBarberia);
		Cliente[] losClientes = new Cliente[10];

		elBarbero.start();

		for (int i = 0; i < nClientes; i++) {
			losClientes[i] = new Cliente(laBarberia, i);
			losClientes[i].start();
		}
	}
}

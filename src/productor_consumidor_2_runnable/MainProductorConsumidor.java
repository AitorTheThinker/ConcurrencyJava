package productor_consumidor_2_runnable;

public class MainProductorConsumidor {
	/*Crea un programa en java, que trabajando con hilos, y trabajando con el modelo 
	 * productor consumidor a través de la librería math.random, 
	 * vamos a crear una clase, en la que va a ir produciendo numeros
	 *  del 1 al 10 y se van a a ir almacenando en una array de máximo 10 números,
	 *   importante mostrar que número se va metiendo en la array, en la clase consumidor
	 *    que vaya quitando los números en la array y decir los valores que añade y quita  */
	public static void main(String args[]) {
		        Buffer buffer = new Buffer();
		        Productor productor = new Productor(buffer);
		        Consumidor consumidor = new Consumidor(buffer);
		        Thread thread1 = new Thread(productor);
		        Thread thread2 = new Thread(consumidor);
		        thread1.start();
		        thread2.start();
	}
}

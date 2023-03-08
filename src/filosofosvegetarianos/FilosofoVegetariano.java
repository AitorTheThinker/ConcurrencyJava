package filosofosvegetarianos;

public class FilosofoVegetariano implements Runnable {
    private int id;
    private Object[] tenedores;

    public FilosofoVegetariano(int id, Object[] tenedores) {
        this.id = id;
        this.tenedores = tenedores;
    }

    public FilosofoVegetariano(int i, Tenedor tenedor, Tenedor tenedor2) {
		// TODO Auto-generated constructor stub
	}

	public void run() {
        while (true) {
            try {
                pensar();
                comer();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 2000));
    }

    private void comer() throws InterruptedException {
        int tenedorIzquierdo = id;
        int tenedorDerecho = (id + 1) % tenedores.length;

        synchronized (tenedores[tenedorIzquierdo]) {
            System.out.println("Filosofo " + id + " tiene el tenedor izquierdo.");
            synchronized (tenedores[tenedorDerecho]) {
                System.out.println("Filosofo " + id + " tiene los dos tenedores y está comiendo.");
                Thread.sleep((long) (Math.random() * 2000));
            }
            System.out.println("Filosofo " + id + " suelta el tenedor derecho.");
        }
        System.out.println("Filosofo " + id + " suelta el tenedor izquierdo y vuelve a pensar.");
    }
}


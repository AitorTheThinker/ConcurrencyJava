package filosofosvegetarianos;

public class Tenedor {

    private int id;
    private boolean disponible;

    public Tenedor(int id) {
        this.id = id;
        this.disponible = true;
    }

    public synchronized boolean tomar() {
        if (disponible) {
            disponible = false;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void dejar() {
        disponible = true;
    }

    public int getId() {
        return id;
    }
}
package barberosdurmientes4threadmal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorSillas {
    private int MAX_SILLAS;
    private boolean[] estaSillaLibre;
    private boolean[] clienteEstaAtendido;
    private int siguienteClienteParaAtender = 0;

    GestorSillas(int num) {
        MAX_SILLAS = num;
        estaSillaLibre = new boolean[MAX_SILLAS];
        clienteEstaAtendido = new boolean[MAX_SILLAS];
        for (int i = 0; i < MAX_SILLAS; i++) {
            estaSillaLibre[i] = true;
            clienteEstaAtendido[i] = false;
        }
    }

    public synchronized int getPosSillaLibre() {
        List<Integer> sillasLibres = new ArrayList<>();
        for (int i = 0; i < this.estaSillaLibre.length; i++) {
            if (!this.estaSillaLibre[i]) {
                sillasLibres.add(i);
            }
        }
        if (sillasLibres.isEmpty()) {
            return -1;
        }
        int randomIndex = new Random().nextInt(sillasLibres.size());
        return sillasLibres.get(randomIndex);
    }

    public void liberarSilla(int pos) {
        estaSillaLibre[pos] = true;
    }
    
    public synchronized int getSiguienteCliente() {
        int pos = -1;
        boolean salir;
        int i;
        salir = false;
        i = this.siguienteClienteParaAtender;
        while (!salir) {
            if ((this.estaSillaLibre[i] == false) && (this.clienteEstaAtendido[i] == false)) {
                this.clienteEstaAtendido[i] = true;
                this.siguienteClienteParaAtender = (i + 1) % MAX_SILLAS;
                return i;
            }
            i++;
            if (i == this.MAX_SILLAS) {
                i = 0;
            }
            if (i == this.siguienteClienteParaAtender)
                salir = true;
        }
        return pos;
    }
}

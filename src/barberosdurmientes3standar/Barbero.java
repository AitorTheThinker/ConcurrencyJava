package barberosdurmientes3standar;

import java.util.Random;

public class Barbero implements Runnable{
    GestorSillas gestorSillas;
    boolean barberiaAbierta;
    public Barbero (GestorSillas g){
            gestorSillas=g;
            barberiaAbierta=true;
    }

    public void cerrarBarberia(){
            this.barberiaAbierta=false;
    }
    @Override
    public void run() {
       while(barberiaAbierta){
               int posSillaClienteSinAtender;
               posSillaClienteSinAtender=
                               this.gestorSillas.getSiguienteCliente();
               if (posSillaClienteSinAtender==-1){
                       esperarTiempoAzar(3);
               } else {
                       System.out.println("Barbero atendiendo silla:" +
                                       posSillaClienteSinAtender);
                       esperarTiempoAzar(3);
                       this.gestorSillas.liberarSilla(posSillaClienteSinAtender);
               }
       }
    }

    public static void esperarTiempoAzar(int max){
            Random generador=new Random();
            /* Se calculan unos milisegundos al azar*/
            int msgs=(1+generador.nextInt(max))*1000;
            try {
                            Thread.currentThread().sleep(msgs);
            } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
            }
    }

}

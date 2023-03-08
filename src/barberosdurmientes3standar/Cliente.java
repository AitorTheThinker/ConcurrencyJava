package barberosdurmientes3standar;

public class Cliente  {
    GestorSillas gestorSillas;
    public Cliente(GestorSillas g){
            this.gestorSillas = g;
    }
    public void entrarEnBarberia(){
            int posSillaLibre = this.gestorSillas.getPosSillaLibre();
            if (posSillaLibre==-1){
                    System.out.println("No habia sillas libres, me marcho");
                    return ;
            }
            System.out.println("Me siento en la silla:"+posSillaLibre);
    }
}

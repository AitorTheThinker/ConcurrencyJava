package pinchaglobosrunnable;

public class GlobosRunnable {
 
    private int maxHinchando=3;
    private int maxGlobos=10;
    private int maxVolumen=5;
    private int nGlobo=1;
    private int hinchandoAhora=0;
    private int globos[];

 
    public GlobosRunnable() {  
        globos=new int[maxGlobos];
        for (int i=0;i<maxGlobos;i++) globos[i]=0; 
    } 
 
    public synchronized int dameGlobo() { 
 
        while (hinchandoAhora==maxHinchando && nGlobo!=maxGlobos+1)  { 
            try {wait();} catch (Exception e) {}
        }
 
        if (nGlobo==maxGlobos+1) return -1; 
        globos[nGlobo-1]=1;                
        System.out.println("GLOBO "+nGlobo+" ENTREGADO A "+Thread.currentThread().getName());    
        notifyAll();   
        return nGlobo++;  
    }
 
    public synchronized boolean pincho() { 
 
        while (hinchandoAhora==0 && nGlobo!=maxGlobos+1){    
            try {wait();} catch (Exception e) {}
        }
 
        if (nGlobo==maxGlobos+1) return true;   
 
        for (int i=0;i<maxGlobos;i++)    
            if (globos[i]>0 && globos[i]<=maxVolumen) {
                System.out.println("GLOBO"+(i+1)+" LO PINCHA "+Thread.currentThread().getName());
                globos[i]=maxVolumen+2;
                hinchandoAhora--;
                notifyAll();
                break;
            }
 
        return hinchandoAhora!=0;
    }
 
    public synchronized boolean hincho(int num) {
 
        if (globos[num-1]<=maxVolumen) globos[num-1]++;   
        else return true;                               
 
        if (globos[num-1]==maxVolumen+1){   
            hinchandoAhora--;
            System.out.println("GLOBO "+num+ " ESTALLA");
            notifyAll();
            return true;
        }
        else {
            System.out.println("GLOBO "+num+" VOLUMEN "+globos[num-1]);
            return false;
        }
    }
}
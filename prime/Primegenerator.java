package prime;
public class Primegenerator extends Thread {
    int lb,ub;
    public Primegenerator(int lb,int ub){
        this.lb=lb;
        this.ub=ub;
    }    
    synchronized boolean isprimecheck(int n){
        if(n<2) return false;
        for(int i=2;i<n;i++){
            if((n%i) == 0) return false;
        } 
        return true;
    }
     public void run(){
        System.out.println("The Prime no.s: ");
        for(int i= lb;i<=ub;i++){
            if(isprimecheck(i)) {
                System.out.println(i);                   
            }
        }
    }
}

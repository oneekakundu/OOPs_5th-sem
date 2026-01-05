package prime;


public class GeneratePrime extends Thread{
    int lb;
    int ub;
    public GeneratePrime(int lb,int ub){
        this.lb=lb;
        this.ub=ub;
    }

    synchronized boolean isPrime(int n){
        if( n < 2) return false;
        for(int i=2;i<n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
public void run(){
    System.out.println("Prime numbers between" + lb + "and"+ ub +":");
    for(int i=lb;i<ub;i++){
        if(isPrime(i)){
            System.out.println(i );
        }
    }
}
}

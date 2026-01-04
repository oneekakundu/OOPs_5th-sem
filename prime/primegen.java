package prime;

class primegen extends Thread {
    int lb,ub,n;
    public primegen(int lb,int ub){
        this.lb=lb;
        this.ub=ub;
    }
    boolean primecheck(int n){
        if(n<2) return false;
        else {
            for(int i=2;i<=n;i++){
            if(n%i == 0) System.out.println(n );
            return false;
        }
        return true;
        }
    }
    public void run(){
        for(int i=lb;i<=ub;i++){
            if(primecheck(i)){
                System.out.println(i );            }
        }
    }
}

import prime.*;
import prime.GeneratePrime;

import java.util.*;
public class TestGeneratePrime {
    public static void main(String[] args){
        Scanner sc= new Scanner(System .in);
        System.out.println("Enter lower limit: ");
        int lb=sc.nextInt();
        System.out.println("Enter upper limit: ");
        int ub=sc.nextInt();

        GeneratePrime t1= new GeneratePrime(lb, ub);
        t1.start();
        // public static void main(String[] args) throws InterruptedException {
        // t1.start();
        // t1.join();   // now allowed

        try{
            t1.join();//join() makes one thread wait until another thread finishes running.
        }catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }
    }
}

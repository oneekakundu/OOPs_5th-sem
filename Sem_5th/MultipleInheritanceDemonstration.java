import java.util.*;
class InvalidInputException extends Exception{
    public InvalidInputException(String msg){
        super(msg);
    }
}
interface Adder{
    public void addInteger();
}
interface Multiplier{
    public void multiplyInteger();
}
class Compute implements Adder,Multiplier{
    int a;
    int b;
    public Compute(int a ,int b){
        this.a=a;
        this.b=b;
    }
    public void addInteger(){
        System.out.println("Sum: "+ (a+b));
    }
    public void multiplyInteger(){
        System.out.println("Mul: "+(a*b));
    }
    public void division() throws InvalidInputException{
        if(b==0){
            throw new InvalidInputException("Division by 0: NOt possible");
        }
        else{
            System.out.println("Division: "+(a/b));
        }
    }
} 
public class MultipleInheritanceDemonstration {
    public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    try {
        System.out.println("Enter the 1st integer:");
        int a = sc.nextInt();
        System.out.println("Enter the 2nd integer:");
        int b = sc.nextInt();
        Compute c =new Compute(a, b);
        c.addInteger();
        c.multiplyInteger();
        c.division();
    } catch (InvalidInputException e) {
        System.out.println("Error:"+ e.getMessage());
    }
    catch(InputMismatchException e){
        System.out.println("Error:"+ e.getMessage());
    }
}
}

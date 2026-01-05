import java.util.*;

class MissingInputException extends Exception{
    public MissingInputException(String message){
        super(message);
    }
}

class Vehicle{
    String name;
    double mileage;
    public Vehicle(String name, double mileage)throws MissingInputException{
        if(name==null || name.trim().isEmpty() ||mileage<0) {
            throw new MissingInputException("Missin Input");
        }
        this.name=name;
        this.mileage=mileage;
    }
}
interface Maintenance{
    void scheduleService();
}
class Car extends Vehicle implements Maintenance{
    private double km=10000;
    public Car(String name, double mileage)throws MissingInputException{
        super(name,mileage);
    }
    public void scheduleService(){
        if (mileage>=km){
            System.out.println("Service needed!!");
        }
        else{
            km=km-mileage;
            System.out.println("Service not needed-----"+km+"km left");
        }
    }
}
class Bike extends Vehicle implements Maintenance{
    private double km=5000;
    public Bike(String name, double mileage)throws MissingInputException{
        super(name,mileage);
    }
    public void scheduleService(){
        if (mileage>=km){
            System.out.println("Service needed!!");
        }
        else{
            km=km-mileage;
            System.out.println("Service not needed-----"+km+"km left");
        }
    }
}
public class VehicleMaintenanceTracker {
    public static void main (String[] args) throws MissingInputException{
        Scanner sc= new Scanner(System.in);
        //Maintenance c= new Car("Wagonar",70000);
        //Maintenance b=new Bike("Shine Sp",700);
        Maintenance c = null;  // declare first
        Maintenance b = null;  // declare first
        //created them inside try block then it cant be accessed
       try {
            System.out.print("Enter the name of the Car: ");
            String s1 = sc.nextLine();

            System.out.print("Enter the mileage of the Car: ");
            double m1 = sc.nextDouble();

            System.out.print("Enter the name of the Bike: ");
            String s2 = sc.nextLine();

            System.out.print("Enter the mileage of the Bike: ");
            double m2 = sc.nextDouble();

            c = new Car(s1, m1);
            b = new Bike(s2, m2);

            c.scheduleService();
            b.scheduleService();

            } catch (MissingInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
            }
    }

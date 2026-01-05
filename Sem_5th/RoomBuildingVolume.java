import java.util.*;
class InvalidException extends Exception{
    public InvalidException(String message){
        super(message);
    }
}
class Room{
    double length,breadth,height;
    public Room(double length,double breadth,double height)throws InvalidException{
        if(length<=0||breadth<=0||height<=0){
            throw new InvalidException("Dimensions must be +ve ");
        }
        this.length=length;
        this.breadth=breadth;
        this.height=height;
    }
}
interface VolumeCalculator{
    double volume();
}
class Building extends Room implements VolumeCalculator{
    public Building(double length,double breadth,double height) throws InvalidException{
        super(length, breadth, height);
    }
    public double volume(){
        return length*breadth*height; 
    }
}
public class RoomBuildingVolume {
    public static void main(String[] args){
        try {
            System.out.print("Enter the name of the Car: ");
            String s1 = sc.nextLine();

            System.out.print("Enter the name of the Bike: ");
            String s2 = sc.nextLine();

            System.out.print("Enter the mileage of the Car: ");
            double m1 = sc.nextDouble();

            System.out.print("Enter the mileage of the Bike: ");
            double m2 = sc.nextDouble();

            Car c = new Car(s1, m1);
            Bike b = new Bike(s2, m2);
            c.scheduleService();
            b.scheduleService();

} catch (MissingInputException e) {
    System.out.println("Error: " + e.getMessage());
} catch (InputMismatchException e) {
    System.out.println("Error: Mileage must be a number!");
}

    } 
}

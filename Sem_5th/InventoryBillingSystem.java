import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Item{
    String name;
    int price;
    int quantity;
    public Item(String name,int price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
}
interface BillCalculator{
    void total();
    void tax();
}
class HardwareItem extends Item implements BillCalculator{
    public HardwareItem(String name,int price,int quantity){
        super(name, price, quantity);
    }
    public void total(){
        System.out.println("Total Price: " + (price*quantity));
    }
    public void tax(){
        System.out.println("Total tax: " + (price*quantity*0.18));//Total*0.18   18% tax 
    }
}
class SoftwareItem extends Item implements BillCalculator{
    public SoftwareItem(String name,int price,int quantity){
        super(name, price, quantity);
    }
    public void total(){
        System.out.println("Total Price: " + (price*quantity));
    }
    public void tax(){
        System.out.println("Total tax: " + (price*quantity*0.12));//Total*0.12  12% tax 
    }
}
public class InventoryBillingSystem {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
 
        try {
            System.out.print("Enter hardware item name: ");
            String n1 = br.readLine();
            System.out.print("Enter hardware price: ");
            int p1 = Integer.parseInt(br.readLine());
            System.out.print("Enter hardware quantity: ");
            int q1 = Integer.parseInt(br.readLine());
            HardwareItem h = new HardwareItem(n1, p1, q1);

            System.out.print("Enter software item name: ");
            String n2 = br.readLine();
            System.out.print("Enter software price: ");
            int p2 = Integer.parseInt(br.readLine());
            System.out.print("Enter software quantity: ");
            int q2 = Integer.parseInt(br.readLine());
            SoftwareItem s = new SoftwareItem(n2, p2, q2);

            h.total();
            h.tax();
            s.total();
            s.tax();
        } catch (IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

import java.util.*;

// Exception for invalid discount
class InvalidDiscountException extends Exception {
    public InvalidDiscountException(String msg) {
        super(msg);
    }
}

// Base Class
class Customer {
    String name;
    int number;
    int purchaseValue;

    public Customer(String name, int number, int purchaseValue) {
        this.name = name;
        this.number = number;
        this.purchaseValue = purchaseValue;
    }

    // To be overridden
    double discountCalculation() throws InvalidDiscountException {
        return 0;
    }
}

// Interface
interface BillOps {
    void calculateBill() throws InvalidDiscountException;
    void displayBill();
}

// Regular Customer (5% discount)
class RegularCustomer extends Customer implements BillOps {

    double finalAmount;

    public RegularCustomer(String name, int number, int purchaseValue) {
        super(name, number, purchaseValue);
    }

    @Override
    double discountCalculation() throws InvalidDiscountException {
        double discount = 0.05 * purchaseValue;
        if (discount < 0)
            throw new InvalidDiscountException("Invalid discount for Regular Customer!");
        return purchaseValue - discount;
    }

    public void calculateBill() throws InvalidDiscountException {
        finalAmount = discountCalculation();
    }

    public void displayBill() {
        System.out.println("----- Regular Customer Bill -----");
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
        System.out.println("Purchase Value: " + purchaseValue);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println("---------------------------------");
    }
}

// Premium Customer (10% discount)
class PremiumCustomer extends Customer implements BillOps {

    double finalAmount;

    public PremiumCustomer(String name, int number, int purchaseValue) {
        super(name, number, purchaseValue);
    }

    @Override
    double discountCalculation() throws InvalidDiscountException {
        double discount = 0.10 * purchaseValue;
        if (discount < 0)
            throw new InvalidDiscountException("Invalid discount for Premium Customer!");
        return purchaseValue - discount;
    }

    public void calculateBill() throws InvalidDiscountException {
        finalAmount = discountCalculation();
    }

    public void displayBill() {
        System.out.println("----- Premium Customer Bill -----");
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
        System.out.println("Purchase Value: " + purchaseValue);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println("---------------------------------"); 
    }
}

// Main Class
public class RetailShopManagement {
    public static void main(String[] args) {

        try {
            RegularCustomer rc = new RegularCustomer("Riya", 101, 2000);
            rc.calculateBill();
            rc.displayBill();

            PremiumCustomer pc = new PremiumCustomer("Arjun", 102, 3000);
            pc.calculateBill();
            pc.displayBill();

        } catch (InvalidDiscountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

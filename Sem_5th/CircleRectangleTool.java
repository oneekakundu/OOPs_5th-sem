import java.util.*;

// Custom Exception
class InvalidDimensionException extends Exception {
    public InvalidDimensionException(String msg) {
        super(msg);
    }
}

// Abstract class
abstract class Shape {
    int a, b;  // For circle -> a = radius, b = 0
    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

// Interface
interface Compute {
    void area();
    void perimeter();
}

// Circle Class
class Circle extends Shape implements Compute {
    public Circle(int r) throws InvalidDimensionException {
        super(r, 0);
        if (r <= 0) {
            throw new InvalidDimensionException("Radius must be positive!");
        }
    }

    public void area() {
        System.out.println("Circle Area = " + Math.PI * a * a);
    }

    public void perimeter() {
        System.out.println("Circle Perimeter = " + 2 * Math.PI * a);
    }
}

// Rectangle Class
class Rectangle extends Shape implements Compute {
    public Rectangle(int l, int b) throws InvalidDimensionException {
        super(l, b);
        if (l <= 0 || b <= 0) {
            throw new InvalidDimensionException("Length and breadth must be positive!");
        }
    }

    public void area() {
        System.out.println("Rectangle Area = " + (a * b));
    }
 
    public void perimeter() {
        System.out.println("Rectangle Perimeter = " + 2 * (a + b));
    }
}

// MAIN CLASS
public class CircleRectangleTool {
    public static void main(String[] args) {
        try {
            Circle c = new Circle(5);
            c.area();
            c.perimeter();

            Rectangle r = new Rectangle(2, 3);
            r.area();
            r.perimeter();
        }
        catch (InvalidDimensionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

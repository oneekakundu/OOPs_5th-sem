import java.util.*;

interface Computation {
    void factorial(int n);
    void power(double base, int exp);
}

class ComputationImpl implements Computation {

    @Override
    public void factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + " = " + fact);
    }

    @Override
    public void power(double base, int exp) {
        double result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        System.out.println(base + " raised to " + exp + " = " + result);
    }

    // Overloaded compute() for integer
    public void compute(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Summation (int) up to " + n + " = " + sum);
    }

    // Overloaded compute() for double
    public void compute(double n) {
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Summation (double) up to " + n + " = " + sum);
    }
}

public class ScientificComputationSuite {
    public static void main(String[] args) {
        
        ComputationImpl c = new ComputationImpl();

        int n = 5;
        double base = 2;
        int exp = 3;

        // Concurrent threads
        Thread t1 = new Thread(() -> c.factorial(n));
        Thread t2 = new Thread(() -> c.power(base, exp));
        Thread t3 = new Thread(() -> c.compute(n));
        Thread t4 = new Thread(() -> c.compute(5.0));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

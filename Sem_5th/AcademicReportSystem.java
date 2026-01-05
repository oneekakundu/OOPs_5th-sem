import java.util.*;

// Custom Exception
class MissingValuesException extends Exception {
    public MissingValuesException(String message) {
        super(message);
    }
}

// Interface
interface Report {
    void generate();
    void display();
}

// Base Student class
class Student {
    String name;
    int[] marks;
    double total;
    double avg;
    String grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

// Derived class Result
class Result extends Student implements Report {

    public Result(String name, int[] marks) {
        super(name, marks);
    }

    public void generate() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        avg = total / marks.length;

        if (avg >= 90) grade = "A+";
        else if (avg >= 80) grade = "A";
        else if (avg >= 70) grade = "B";
        else if (avg >= 60) grade = "C";
        else grade = "F";
    }

    public void display() {
        System.out.println("\n--- Report for " + name + " ---");
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
    }
}

// Main class
public class AcademicReportSystem {
    public static void main(String[] args) throws MissingValuesException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        sc.nextLine(); // clear newline

        System.out.println("Enter the number of subjects:");
        int m = sc.nextInt();
        sc.nextLine(); // clear newline

        Result[] studentResults = new Result[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter the name of student " + (i + 1) + ":");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                throw new MissingValuesException("Student name cannot be empty!");
            }

            int[] marks = new int[m];
            for (int j = 0; j < m; j++) {
                System.out.println("Enter marks for subject " + (j + 1) + ":");
                marks[j] = sc.nextInt();
                sc.nextLine(); // clear newline
            }

            studentResults[i] = new Result(name, marks);
            studentResults[i].generate();
        }

        System.out.println("\n===== Academic Report =====");
        for (Result r : studentResults) {
            r.display();
        }
    }
}

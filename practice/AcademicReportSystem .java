import java.util.*;

class MissingValueException extends Exception{
    public MissingValueException(String msg){
        super(msg);

    }
}
interface Report{
    void generate();
    void display();
}
class Student{
    String name;
    int[] marks;
    double total;
    double avg;
    String grade;

    public Student(String name,int[] marks){
        this.name=name;
        this.marks=marks;
    }
}
class Result extends Student implements Report{
    public Result(String name,int[] marks){
        super(name, marks);
    }
    public void generate(){
        total=0;
        for( int m : marks){
            total += m;
        }
        avg = total/marks.length;

        if(avg>=90) grade="A+";
        else if(avg>=80) grade="A";
        else if(avg>=70) grade="B";
        else if(avg>=60) grade="C";
        else grade="F";
    }
    public void display(){
        System.out.println("----Result----");
        System.out.println("Total= "+ total);
        System.out.println("Average= "+ avg);
        System.out.println("Grade = "+ grade);
    }
}
public class AcademicReportSystem{
    public static void main(String [] args)throws MissingValueException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of students: ");
        int n=sc.nextInt();
        System.out.println("Enter the no. of subjects: ");
        int m=sc.nextInt();
        sc.nextLine();

        Result[] s = new Result[n];
        int[] marks=new int[m]
        for(int i=0;i<n;i++){
            System.out.println("Enter the name of the student: ");
            String name=sc.nextLine();
            if(name== null||name.isEmpty()){
                throw new MissingValueException(" Empty name cant be given!!");
            }
            for(int j=0;j<m;j++){
                System.out.println("Enter the marks of the student in"+ (j+1)+"sub");
                marks[j] = sc.nextInt();
                sc.nextLine(); 
            }
            s[i]=new Result(name,marks);
            s[i].generate();
            s[i].display();
        }
    }
}

import java.util.*;
class MissingValuesException extends Exception{
    public MissingValuesException(String msg){
        super(msg);
    }
}
interface Report{
    void generate();
    void display();
}
class Student{
    int total;
    int[] marks;
    double avg;
    String name,grade;
    public Student(String name,int[] marks){
        this.name=name;
        this.marks=marks;
    }
}
class Result extends Student implements Report{
    public Result(String name,int[] marks){
        super(name,marks);
    }
    public void generate(){
        for(int m: marks){
        total +=m;
    }
        avg=(total/marks.length);
        if(avg>=90) grade= "A+";
        else if (avg>= 80) grade="A";
        else if (avg>= 70) grade="B";
        else if (avg>= 60) grade="C";
        else grade="F";
    }
    public void display(){
        System.out.println("----Results----");
        System.out.println("Name: "+ name);
        System.out.println("Total : "+ total);
        System.out.println("Grade: "+ grade);
    }

}

public class AcademicReportSystem{
   public static void main(String[] args){

    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the no. of students : ");
    int n = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the no. of sub : ");
    int m = sc.nextInt();
    sc.nextLine();
    Result[] s = new Result[n];
    for(int i=0;i<n;i++){
        System.out.println("Enter the name of student : ");
        String name =sc.nextLine();
        int[] marks= new int[m];
        for(int j=0;j<m;j++){
            System.out.println("Enter the marks : ");
            marks[j] = sc.nextInt();
                            sc.nextLine(); 

        }
        s[i]=new Result(name, marks);
        s[i].generate();
        s[i].display();
    }
   }

}

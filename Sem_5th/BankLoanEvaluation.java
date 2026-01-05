import java.util.*;
class InvalidLoanAmtException extends Exception{
    public InvalidLoanAmtException(String msg){
        super(msg);
    }
}
interface LoanRules{
    void calculateEMI();
    void displayDetails();
}
class Applicant{
    String name;
    int age;
    double income;

    public Applicant(String name,int age,double income){
        this.name=name;
        this.age=age;
        this.income=income;
    }
    boolean isEligible(){
        return income>=20000;
    }
}
class LoanApplicant extends Applicant implements LoanRules{
    double loanAmt;
    LoanApplicant(String name,int age,double income,double loanAmt)throws InvalidLoanAmtException{
            super(name,age,income);
            if(loanAmt <=0){
                throw new InvalidLoanAmtException("Loan Amt Cannot be 0 !");
            }
            this.loanAmt=loanAmt;
        }
        boolean isEligible(){
            return income>=25000;
        }
        public void calculateEMI(){
            double emi = loanAmt/12;//simple 1-year division
            System.out.println("EMI per month: "+ emi);
        }
        public void displayDetails(){
            System.out.println("-------Applicant details ------");
            System.out.println("Name:"+name);
            System.out.println("Age:"+ age);
            System.out.println("Income: " + income);
            System.out.println("Loan Amount: " + loanAmt);

            if (isEligible()) {
                System.out.println("Eligibility: Eligible");
            calculateEMI();
            }
            else {
                System.out.println("Eligibility: Not Eligible");
            }
    }
}
public class BankLoanEvaluation {
    public static void main(String[] args) {

        try {
            LoanApplicant a = new LoanApplicant("Riya", 28, 30000, 120000);
            a.displayDetails();

        } catch (InvalidLoanAmtException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}

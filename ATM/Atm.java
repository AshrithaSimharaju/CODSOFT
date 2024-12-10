import java.util.*;
class BankAccount{
    private double balance;
    
    public double getbalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount<=0){
          throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance+=amount;
    }
    public boolean withdraw(double amount){
        if(amount>balance){
            return(false);
        }
        if(amount<=0){
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        balance-=amount;
        return true;
    }

}
class ATM{
    private BankAccount account;
    
    public ATM(BankAccount account){
        this.account=account;
    } 

    public void displayMenu(){
       System.out.println("Choose an option:");
       System.out.println("Enter 1. To check balance");
       System.out.println("Enter 2. To deposit amount");
       System.out.println("Enter 3. To withdraw amount");
       System.out.println("Enter 4. To exit");
    }
    public void start(){
        Scanner sc=new Scanner(System.in);
        boolean exit=false;
        while(!exit){
        displayMenu();
        int choice=sc.nextInt();

        switch(choice){
            case 1:
                System.out.printf("Your current balance is: $%.2f%n", account.getbalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = sc.nextDouble();
                try {
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = sc.nextDouble();
                    try {
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful!");
                        } else {
                            System.out.println("Insufficient funds for this withdrawal.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Thank you!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();

        } 
    }
public class Atm{
    public static void main(String[]args){
        BankAccount userAccount = new BankAccount();
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

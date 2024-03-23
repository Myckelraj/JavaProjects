import java.util.Scanner;

public class Atm_program {
    private double balance;
     public Atm_program(double initialAmount){
        balance=initialAmount;
    }
     public void deposit(double amount)
     {
        balance=balance+amount;
        System.out.println("Amount Deposited "+amount);
     }

    public void withDraw(double amount){
        if (balance>=amount) {
            balance-=amount;
            System.out.println("Withdrawn amount "+amount);
        }
        else{
            System.out.println("Insufficient Amount.");
        }
    }
     public double checkBalance()
     {
        return balance;
     }


    public static void main(String[] args) {
        Atm_program atm=new Atm_program(10000.0);
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Select Options");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Check balance");
                System.out.println("4.Exit");
                System.out.println("Enter your Choice:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the Deposit Amount:");
                        double depositAmount = sc.nextInt();
                        atm.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.println("Enter the withdrawal amount");
                        double withdrawalAmount = sc.nextInt();
                        atm.withDraw(withdrawalAmount);
                    }
                    case 3 -> System.out.println("Balance is " + atm.checkBalance());
                    case 4 -> {
                        System.out.println("Thanks You.");
                        System.exit(0);
                    }
                    default -> {
                    }
                }
            }
        }
    }
    
}

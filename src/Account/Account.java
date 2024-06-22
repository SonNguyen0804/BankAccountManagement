package Account;

import java.util.Scanner;

public class Account {

    private long accountNumber;
    private String accountName;
    private double balance;

    private static final double INTEREST_RATE = 0.035;

    //Constructor
    public Account() {
        this.accountNumber = 0;
        this.accountName = "";
        this.balance = 50000;
    }

    public Account(long accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    //Getter and Setter methods
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account:" + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Account Name: " + accountName + "\n" +
                "Balance: " + balance + "VND";
    }

    //Method to deposit money
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit successfully!");
        } else {
            System.out.println("Invalid amount! Number must be greater than 0!");
        }
    }

    //Method to withdraw money
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= (amount + 10000);
            System.out.println("Withdraw successfully!");
        } else {
            System.out.println("Invalid amount! Please check your balance and amount you want to withdraw!");
        }
    }

    //Method to add interest
    public void addInterest() {
        balance += balance * INTEREST_RATE;
    }

    //Method to transfer money
    public void transfer(Account toAnotherAccount, double amount) {
        if(amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAnotherAccount.deposit(amount);
            System.out.println("Transfer successfully!");
        } else {
            System.out.println("Transfer failed! Please check your balance and amount you want to transfer!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        while (true) {
            System.out.println("1. Input customer information");
            System.out.println("2. List of information of customer");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Add interest");
            System.out.println("6. Transfer money");
            System.out.println("Press 0 to Exit");
            System.out.println("Please choose function you'd like to do:");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Input account number:");
                    long accountNumber = scanner.nextLong();
                    account.setAccountNumber(accountNumber);

                    System.out.println("Input account name:");
                    scanner.nextLine();
                    String accountName = scanner.nextLine();
                    account.setAccountName(accountName);

                    System.out.println("Input balance:");
                    double balance = scanner.nextDouble();
                    account.setBalance(balance);
                    break;
                case 2:
                    System.out.println(account.toString());
                    break;
                case 3:
                    System.out.println("Input amount you want to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Input amount you want to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 5:
                    account.addInterest();
                    System.out.println("Add interest successfully!");
                    break;
                case 6:
                    System.out.println("Input account number you want to transfer:");
                    long accountNumberToTransfer = scanner.nextLong();
                    System.out.println("Input amount you want to transfer:");
                    double amountToTransfer = scanner.nextDouble();
                    Account toAnotherAccount = new Account();
                    toAnotherAccount.setAccountNumber(accountNumberToTransfer);
                    account.transfer(toAnotherAccount, amountToTransfer);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please choose again!");
            }
        }
    }

}

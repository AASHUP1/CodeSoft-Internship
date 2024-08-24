import java.util.Scanner;

class FinancialAccount {
    private double currentBalance;

    public FinancialAccount(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    public double getAccountBalance() {
        return currentBalance;
    }

    public void setAccountBalance(double newBalance) {
        this.currentBalance = newBalance;
    }

    public void addFunds(double amount) {
        currentBalance += amount;
    }

    public boolean removeFunds(double amount) {
        if (currentBalance >= amount) {
            currentBalance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATM {
    private FinancialAccount userAccount;

    public ATM(FinancialAccount account) {
        this.userAccount = account;
    }

    public void initiateSession() {
        Scanner userInp = new Scanner(System.in);
        int userChoice;

        while (true) {
            System.out.println("Automated Teller Machine Menu:");
            System.out.println("1. View Account Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit Session");
            System.out.print("Enter your choice: ");
            userChoice = userInp.nextInt();

            switch (userChoice) {
                case 1:
                    displayAccountBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    System.out.println("Exiting session...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayAccountBalance() {
        System.out.println("Your current account balance is: $" + userAccount.getAccountBalance());
    }

    private void depositFunds() {
        Scanner userInp = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double depositAmount = userInp.nextDouble();

        userAccount.addFunds(depositAmount);
        System.out.println("Deposit successful. Your new account balance is: $" + userAccount.getAccountBalance());

    }

    private void withdrawFunds() {
        Scanner userInp = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double withdrawalAmount = userInp.nextDouble();
        if (userAccount.removeFunds(withdrawalAmount)) {
            System.out.println("Withdrawal successful. Your new account balance is: $" + userAccount.getAccountBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        FinancialAccount userAccount = new FinancialAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.initiateSession();
    }
}
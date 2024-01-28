
import java.util.Scanner;

// Bank Account class representing the user's account
class BankAcc {
    private double balance;

    public BankAcc(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Withdrawal failed
    }
}

// ATM class representing the ATM machine
 class ATM {
    private BankAcc userAcc;
    private Scanner scanner;

    public ATM(BankAcc userAccount) {
        this.userAcc = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeOption(int op) {
        switch (op) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (userAcc.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + userAcc.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    public void deposit() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();

        userAcc.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + userAcc.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + userAcc.getBalance());
    }

    public static void main(String[] args) {
        // Initialize the user's bank account with an initial balance
        BankAcc userAcc = new BankAcc(2000.0);

        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(userAcc);

        while (true) {
            // Display the ATM menu
            atm.display();

            // Get user input for menu option
            System.out.print("Enter option (1-4): ");
            int op= atm.scanner.nextInt();

            // Execute the chosen option
            atm.executeOption(op);
        }
    }
}

    


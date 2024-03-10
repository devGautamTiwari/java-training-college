import java.util.Scanner;

public class MiniAtmSimulator {
    private double balance = 0;
    private Scanner keyboard = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println("Welcome to the ATM!");
    }

    public void printMenu() {
        System.out.println("---------- Menu ----------");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public int inputAction() {
        System.out.print("Enter your action: ");
        int action = Integer.parseInt(keyboard.nextLine());
        return action;
    }

    public void performAction(int actionId) {
        switch (actionId) {
            case 1:
                this.printBalance();
                break;
            case 2:
                this.deposit();
                this.printBalance();
                break;
            case 3:
                this.withdraw();
                this.printBalance();
                break;
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action!");
                break;
        }
    }

    public void printBalance() {
        System.out.println("Your balance is: " + this.balance);
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = Double.parseDouble(keyboard.nextLine());
        if (amount < 0) {
            System.out.println("Invalid amount!");
        } else {
            this.balance += amount;
        }

    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = Double.parseDouble(keyboard.nextLine());
        if (amount < 0) {
            System.out.println("Invalid amount!");
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance!");
        } else {
            this.balance -= amount;
        }
    }

    public static void main(String[] args) {
        MiniAtmSimulator atm = new MiniAtmSimulator();
        atm.printWelcomeMessage();

        do {
            atm.printMenu();
            int action = atm.inputAction();
            atm.performAction(action);
        } while (true);
    }
}

package labs.day2.lab1;

class Bank {
    double amount;

    Bank() {
        this(10000);
    }

    Bank(double amount) {
        this.amount = amount;
    }

    public void withdraw(double withdrawalAmount) {
        this.amount = (withdrawalAmount > amount) ? this.amount : this.amount - withdrawalAmount;

        String message = (withdrawalAmount > amount) ? "Insufficient funds" : "Withdrawal successful";

        System.out.println(message);
    }

    public void deposit(double depositAmount) {
        this.amount += depositAmount;
        System.out.println("Deposit successful");
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + this.amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(10000);

        bank.checkBalance();

        System.out.print("Withdrawing 50000...");
        bank.withdraw(50000);

        System.out.print("Withdrawing 2000...");
        bank.withdraw(2000);
        bank.checkBalance();

        System.out.print("Depositing 5000...");
        bank.deposit(5000);
        bank.checkBalance();
    }
}

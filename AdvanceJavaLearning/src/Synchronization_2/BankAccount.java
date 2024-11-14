package Synchronization_2;

public class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0;
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
        System.out.println("Credited amount : " + amount);
    }
    public synchronized void withdraw(double amount) {
        if(amount > this.balance) {
            System.out.println("Insufficient funds");
            return;
        }
        this.balance -= amount;
        System.out.println("Debited amount : " + amount  );
    }

    public double getBalance() {
        return this.balance;
    }
}

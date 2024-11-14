package Synchronization_2;

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create threads for depositing and withdrawing
        Thread depositThread = new Thread(() -> account.deposit(500));
        Thread withdrawThread = new Thread(() -> account.withdraw(300));

        // Start both threads
        depositThread.start();
        withdrawThread.start();





    }
}

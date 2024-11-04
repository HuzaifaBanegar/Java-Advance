package Threads;
public class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number "+this.number + " Is Printed by:" + Thread.currentThread().getName());
    }
}

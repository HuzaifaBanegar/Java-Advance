package Threads;

public class NumberPrinter2 extends Thread{

    private int number;

    public NumberPrinter2(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number "+this.number + " Is Printed by:" + Thread.currentThread().getName());

    }
}

package Threads;

public class NumberPrinter implements  Runnable{
    private int number;

    NumberPrinter(int num){
        number = num;
    }
    public void run(){
        System.out.println("Printing from thread"+Thread.currentThread().getName()+":"+ number);
    }
}

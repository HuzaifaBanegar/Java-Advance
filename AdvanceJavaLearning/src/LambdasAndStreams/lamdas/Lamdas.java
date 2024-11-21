package LambdasAndStreams.lamdas;

public class Lamdas {
    public static void main(String[] args) {
        //Lamdas ar only valid for single Abstract methods
        // Lamdas are anonymous implementation of single abstract methods
        Thread t = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+" says hello");
        });

        t.start();

        MathOperation addOperation = (a, b)->{
            return a+b;
        };

        System.out.println("Adding through lamda function: "+addOperation.add(1,2));


    }
}

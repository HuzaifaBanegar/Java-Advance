package Threads;

public class Client1 {
    public static void main(String[] args) {
        // Manual thread creation:
        for(int i=1; i<=100; i++){
            //In this we implemented NumberPrinter using Runnaple Interface
            Thread thread = new Thread(new NumberPrinter((i)));
            thread.start();
        }


        for(int i=101; i<=200; i++){
            //In this we implemented NumberPrinter using Extend Threads class
           NumberPrinter2 numberPrinter = new NumberPrinter2(i);
           numberPrinter.start();
        }

    }
}

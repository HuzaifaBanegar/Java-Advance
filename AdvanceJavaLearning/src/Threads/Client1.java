package Threads;

public class Client1 {
    public static void main(String[] args) {
        // Manual thread creation:
        for(int i=1; i<=100; i++){
            NumberPrinter numPrinter = new NumberPrinter(i);
            Thread t = new Thread(numPrinter);
            t.start();
        }
    }
}

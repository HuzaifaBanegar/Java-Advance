package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client2 {
    public static void main(String[] args) {
        // Creating and managing thread using Executor / thread-pool
//        Executor executor = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=1; i<=100; i++){
            if(i==2 || i==20){
                System.out.println("DEBUG");
            }
            NumberPrinter numPrinter = new NumberPrinter(i);
            executorService.execute(numPrinter);
        }

        executorService.shutdown();
    }
}

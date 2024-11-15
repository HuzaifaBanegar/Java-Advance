package ExecutorService_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> callable1 = new TaskManager(8);
        Callable<Integer> callable2 = new TaskManager(3);
        Callable<Integer> callable3 = new TaskManager(5);

        Future<Integer> future1 = executor.submit(callable1);
        Future<Integer> future2 = executor.submit(callable2);
        Future<Integer> future3 = executor.submit(callable3);

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }
}

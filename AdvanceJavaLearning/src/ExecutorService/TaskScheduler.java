package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskScheduler {
    public static void main(String[] args) {

        // Here Task 1 and Task 2 had to run seperately as it is managed by single thread
        // And one will execute only after Completion of another
        // However Task 3 is managed by Main method's thread, and it will run in parellel with Task1

        // newSingleThreadExecutor - Takes one Thread at a time
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task 1 is running");
                for(int i=0; i<100; i++){
                    System.out.print(i+" ");
                }
                System.out.println("Task 1 is done");

            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task 2 is running");
                for(int i=101; i<200; i++){
                    System.out.print(i+" ");
                }
                System.out.println("Task 2 is done");

            }
        });


        System.out.println("Task 3 is running");
        for(int i=201; i<300; i++){
            System.out.print(i+" ");
        }

        System.out.println("Task 3 is done");

        executorService.shutdown();




    }
}

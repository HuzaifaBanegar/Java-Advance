package ExecutorService_2;

import java.util.concurrent.Callable;

// You want to execute multiple tasks in parallel and retrieve their results in Java.
// You’ve heard about Callable and ExecutorService, but you’re not sure how they work together. Write a program to demonstrate:
// How to use a Callable class to perform a task that returns a result.
// How to use an ExecutorService to manage multiple tasks and collect their results.
// Do a factorialTask Manager
public class TaskManager implements Callable<Integer> {

    private int number;

    public TaskManager(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        for(int i=1; i<=number ; i++){
            result *= i;
            Thread.sleep(1000);
        }
        System.out.println("Factorial of "+ number+" is "+"calculated");
        return result;
    }
}

package DoughnutFactoryProblem.UsingInteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfConsumers = 10;
        DougnutFactory dougnutFactory = new DougnutFactory(20);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Lock lock = new ReentrantLock();
        Consumer consumer = new Consumer(dougnutFactory, lock);

        for(int i=1; i<=numberOfConsumers; i++) {
            executor.submit(()->{
                consumer.consume(1);
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Consumer consumed 10 doughnuts and remaining are: "+ dougnutFactory.getDoughnutCounter());

    }
}

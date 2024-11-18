package DoughnutFactoryProblem.UsingAtomicInteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicMain {
    public static void main(String[] args) throws InterruptedException {
        int numberOfConsumers = 10;
        AtomicDoughnutFactory doughnutFactory = new AtomicDoughnutFactory(20);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        AtomicConsumer consumer = new AtomicConsumer(doughnutFactory);

        for (int i = 1; i <= numberOfConsumers; i++) {
            executor.submit(()->{
               consumer.consume(1);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Consumer consumed 10 doughnuts and remaining are: "+ doughnutFactory.getDoughnutCount());


    }
}

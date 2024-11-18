package DoughnutFactoryProblem.UsingInteger;

import java.util.concurrent.locks.Lock;

public class Consumer {
    private DougnutFactory doughnutFactory;
    Lock lock;
    public Consumer(DougnutFactory doughnutFactory, Lock lock) {
        this.doughnutFactory = doughnutFactory;
        this.lock = lock;
    }

    public void consume(int numberOfDoughnutsToConsume) {
            synchronized (lock){
                lock.lock();
                System.out.println("Doughnut number "+doughnutFactory.getDoughnutCounter()+" is being consumed by consumer on Thread: " + Thread.currentThread().getName());
                doughnutFactory.setDougnutsCounter( doughnutFactory.getDoughnutCounter() - numberOfDoughnutsToConsume);
                System.out.println("Doughnuts left:"+ doughnutFactory.getDoughnutCounter());
                lock.unlock();
            }



    }
}


package Mutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    public Counter counter;
    public Lock lock;

    public Adder(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=1; i<=100; i++){

                lock.lock();
                counter.count = counter.count + i;
                lock.unlock();

        }

    }
}
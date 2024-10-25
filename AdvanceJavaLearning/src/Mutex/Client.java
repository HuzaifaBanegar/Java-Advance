package Mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.val =0;
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor sub = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(sub);


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.val);
    }


}

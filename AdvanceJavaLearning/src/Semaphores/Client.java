package Semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // ConcurrentLinkedQueue: Utilize atomic operations to ensure thread safety without locks
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        Semaphore producer = new Semaphore(6);
        Semaphore consumer = new Semaphore(0);

        Producer p1 = new Producer(queue, producer, consumer);
        Producer p2 = new Producer(queue, producer, consumer);
        Producer p3 = new Producer(queue, producer, consumer);
        Producer p4 = new Producer(queue, producer, consumer);
        Producer p5 = new Producer(queue, producer, consumer);
        Producer p6 = new Producer(queue, producer, consumer);

        Consumer c1 = new Consumer(queue, producer, consumer);
        Consumer c2 = new Consumer(queue, producer, consumer);
        Consumer c3 = new Consumer(queue, producer, consumer);
        Consumer c4 = new Consumer(queue, producer, consumer);
        Consumer c5 = new Consumer(queue, producer, consumer);

        Thread tp1 = new Thread(p1);
        Thread tp2 = new Thread(p2);
        Thread tp3 = new Thread(p3);
        Thread tp4 = new Thread(p4);
        Thread tp5 = new Thread(p5);
        Thread tp6 = new Thread(p6);

        Thread tc1 = new Thread(c1);
        Thread tc2 = new Thread(c2);
        Thread tc3 = new Thread(c3);
        Thread tc4 = new Thread(c4);
        Thread tc5 = new Thread(c5);

        tp1.start();
        tp2.start();
        tp3.start();
        tp4.start();
        tp5.start();
        tp6.start();

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
        tc5.start();


    }
}

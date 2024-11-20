package Semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client{
    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer producer1 = new Producer(queue, producerSemaphore, consumerSemaphore);
        Producer producer2 = new Producer(queue, producerSemaphore, consumerSemaphore);
        Producer producer3 = new Producer(queue, producerSemaphore, consumerSemaphore);
        Producer producer4 = new Producer(queue, producerSemaphore, consumerSemaphore);
        Producer producer5 = new Producer(queue, producerSemaphore, consumerSemaphore);
        Producer producer6 = new Producer(queue, producerSemaphore, consumerSemaphore);

        Consumer consumer1 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer consumer2 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer consumer3 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer consumer4 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer consumer5 = new Consumer(queue, consumerSemaphore, producerSemaphore);

        Thread tp1 = new Thread(producer1);
        Thread tp2 = new Thread(producer2);
        Thread tp3 = new Thread(producer3);
        Thread tp4 = new Thread(producer4);
        Thread tp5 = new Thread(producer5);
        Thread tp6 = new Thread(producer6);

        Thread tc1 = new Thread(consumer1);
        Thread tc2 = new Thread(consumer2);
        Thread tc3 = new Thread(consumer3);
        Thread tc4 = new Thread(consumer4);
        Thread tc5 = new Thread(consumer5);

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
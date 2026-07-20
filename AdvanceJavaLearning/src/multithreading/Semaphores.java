package multithreading;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

class Consumer implements Runnable{
    Queue<Object> queue;
    Semaphore consumerSemaphore;
    Semaphore producerSemaphore;
    Consumer(Queue<Object> queue, Semaphore consumerSemaphore, Semaphore producerSemaphore){
        this.queue = queue;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            try{
                consumerSemaphore.acquire();
                if(!queue.isEmpty()){
                    System.out.println("Consuming...");
                    queue.remove();
                }
                producerSemaphore.release();
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
        }
    }

}


class Producer implements Runnable{
    Queue<Object> queue;
    Semaphore consumerSemaphore;
    Semaphore producerSemaphore;
    Producer(Queue<Object> queue, Semaphore consumerSemaphore, Semaphore producerSemaphore){
        this.queue = queue;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run(){
        while(true){
                try {
                    if(queue.size()<6){
                        producerSemaphore.acquire();
                        System.out.println("Producing...");
                        queue.add(new Object());
                    }
                    consumerSemaphore.release();
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
        }
    }

}
public class Semaphores {

    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        Semaphore consumerSemaphore = new Semaphore(0);
        Semaphore producerSemaphore = new Semaphore(6);
        Consumer c1 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer c2 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer c3 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer c4 = new Consumer(queue, consumerSemaphore, producerSemaphore);
        Consumer c5 = new Consumer(queue, consumerSemaphore, producerSemaphore);


        Producer p1 = new Producer(queue, consumerSemaphore, producerSemaphore);
        Producer p2 = new Producer(queue, consumerSemaphore, producerSemaphore);
        Producer p3 = new Producer(queue, consumerSemaphore, producerSemaphore);
        Producer p4 = new Producer(queue, consumerSemaphore, producerSemaphore);
        Producer p5 = new Producer(queue, consumerSemaphore, producerSemaphore);
        Producer p6 = new Producer(queue, consumerSemaphore, producerSemaphore);

        Thread tc1 = new Thread(c1);
        Thread tc2 = new Thread(c2);
        Thread tc3 = new Thread(c3);
        Thread tc4 = new Thread(c4);
        Thread tc5 = new Thread(c5);
        Thread tp1 = new Thread(p1);
        Thread tp2 = new Thread(p1);
        Thread tp3 = new Thread(p2);
        Thread tp4 = new Thread(p3);
        Thread tp5 = new Thread(p4);
        Thread tp6 = new Thread(p5);
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

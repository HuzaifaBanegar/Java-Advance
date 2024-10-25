package Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue queue;
    private Semaphore producer;
    private Semaphore consumer;
    public Consumer(Queue queue, Semaphore producer, Semaphore consumer) {
        this.queue = queue;
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true){
            try {
                consumer.acquire();
                if(!queue.isEmpty()){
                    System.out.println("Consuming");
                    queue.remove();
                }
                producer.release();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
    }
}
